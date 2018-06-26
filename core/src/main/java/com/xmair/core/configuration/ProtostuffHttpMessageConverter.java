package com.xmair.core.configuration;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.xmair.core.util.ProtobufUtil;
import com.xmair.core.util.SpringBeanTools;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * 在httpheader中指定
 * accept conten-type :application/x-protobuf
 * </p>
 */
public class ProtostuffHttpMessageConverter extends AbstractGenericHttpMessageConverter<Object>
{
    public static final Charset   DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final MediaType MEDIA_TYPE      = new MediaType("application", "x-protobuf", DEFAULT_CHARSET);


    /**
     * Construct a new instance.
     */
    public ProtostuffHttpMessageConverter()
    {
        super(MEDIA_TYPE);
    }

    @Override
    public Object read(Type type, Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {

        JavaType javaType=getJavaType(type,aClass);

        return  this.readInternal(javaType.getRawClass(),httpInputMessage);
    }
    private ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType contextType) {
        ResolvableType resolvedType;
        if (contextType.hasGenerics()) {
            resolvedType = ResolvableType.forType(typeVariable, contextType);
            if (resolvedType.resolve() != null) {
                return resolvedType;
            }
        }

        ResolvableType superType = contextType.getSuperType();
        if (superType != ResolvableType.NONE) {
            resolvedType = this.resolveVariable(typeVariable, superType);
            if (resolvedType.resolve() != null) {
                return resolvedType;
            }
        }

        ResolvableType[] var5 = contextType.getInterfaces();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            ResolvableType ifc = var5[var7];
            resolvedType = this.resolveVariable(typeVariable, ifc);
            if (resolvedType.resolve() != null) {
                return resolvedType;
            }
        }

        return ResolvableType.NONE;
    }
    protected JavaType getJavaType(Type type, Class<?> contextClass) {
        TypeFactory typeFactory = SpringBeanTools.getBean(ObjectMapper.class).getTypeFactory();
        if (contextClass != null) {
            ResolvableType resolvedType = ResolvableType.forType(type);
            if (type instanceof TypeVariable) {
                ResolvableType resolvedTypeVariable = this.resolveVariable((TypeVariable)type, ResolvableType.forClass(contextClass));
                if (resolvedTypeVariable != ResolvableType.NONE) {
                    return typeFactory.constructType(resolvedTypeVariable.resolve());
                }
            } else if (type instanceof ParameterizedType && resolvedType.hasUnresolvableGenerics()) {
                ParameterizedType parameterizedType = (ParameterizedType)type;
                Class<?>[] generics = new Class[parameterizedType.getActualTypeArguments().length];
                Type[] typeArguments = parameterizedType.getActualTypeArguments();

                for(int i = 0; i < typeArguments.length; ++i) {
                    Type typeArgument = typeArguments[i];
                    if (typeArgument instanceof TypeVariable) {
                        ResolvableType resolvedTypeArgument = this.resolveVariable((TypeVariable)typeArgument, ResolvableType.forClass(contextClass));
                        if (resolvedTypeArgument != ResolvableType.NONE) {
                            generics[i] = resolvedTypeArgument.resolve();
                        } else {
                            generics[i] = ResolvableType.forType(typeArgument).resolve();
                        }
                    } else {
                        generics[i] = ResolvableType.forType(typeArgument).resolve();
                    }
                }

                return typeFactory.constructType(ResolvableType.forClassWithGenerics(resolvedType.getRawClass(), generics).getType());
            }
        }

        return typeFactory.constructType(type);
    }
    @Override
    protected Object readInternal(Class<?> aClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        if (MEDIA_TYPE.isCompatibleWith(inputMessage.getHeaders().getContentType()))
        {
            final Schema<?> schema =ProtobufUtil.getSchema(aClass);

            final Object value = schema.newMessage();

            try (final InputStream stream = inputMessage.getBody())
            {
                ProtobufIOUtil.mergeFrom(stream, value, (Schema<Object>) schema);

                return value;
            }
        }

        throw new HttpMessageNotReadableException("Unrecognized HTTP media type " + inputMessage.getHeaders().getContentType().getType() + ".");
    }




    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supports(final Class<?> clazz)
    {
        return  true;
    }

    @Override
    protected void writeInternal(Object o, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (MEDIA_TYPE.isCompatibleWith(outputMessage.getHeaders().getContentType()))
        {
            try (final OutputStream stream = outputMessage.getBody())
            {
                ProtobufIOUtil.writeTo(stream
                        , o
                        , ProtobufUtil.getSchema((Class<Object>) o.getClass())
                        , LinkedBuffer.allocate());
            }
        }
        else
        {
            throw new HttpMessageNotWritableException("Unrecognized HTTP media type " + outputMessage.getHeaders().getContentType().getType() + ".");
        }
    }


}
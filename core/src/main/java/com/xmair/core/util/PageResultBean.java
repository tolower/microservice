package com.xmair.core.util;

/*
* 分页数据格式
* */
public class PageResultBean<T> extends  ResultBean<T> {

    private  int pageNum;
    private  int pageSize;
    private long total;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }




}

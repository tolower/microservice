package com.xmair.core.exception;

import java.util.HashMap;

/**
 * Created by wd on 2016-7-20.
 */


public class MsgFactory {

  public static class BusinessErr{
    public static MsgContentStruct requestTooOften = new MsgContentStruct("request_too_often", "请求过于频繁，请稍候再试");
    public static MsgContentStruct requestForbidden = new MsgContentStruct("request_forbidden", "禁止访问");
    public static MsgContentStruct relationInputInvalid = new MsgContentStruct("relation_Input_Invalid", "关系人信息输入不合法：%s");
    public static MsgContentStruct relationVerifyError = new MsgContentStruct("relation_Verify_Error", "关系人验证失败：%s");

    public static MsgContentStruct mobileInfoNotExist = new MsgContentStruct("mobile_info_not_exist", "抱歉，您手机号信息不存在，请联系客服补充手机信息后再试");//旧APP：请旅客联系客服先行补充手机信息后再设置密码
    public static MsgContentStruct passwordTooSimple = new MsgContentStruct("password_too_simple", "抱歉，您的密码太简单，为提高账户安全性，请进行密码找回");//旧APP：当前密码过于简单，为提高账户安全性，请进行密码找回
    public static MsgContentStruct getVerifyCodeTooOften = new MsgContentStruct("get_verify_code_too_often", "请求验证码太频繁");
    public static MsgContentStruct smVerifyCodeCheckFail = new MsgContentStruct("sm_verify_code_check_fail", "短信验证码验证失败");

    public static MsgContentStruct addFocusFlightFail = new MsgContentStruct("add_focus_flight_fail", "该航班已添加该关注");
    public static MsgContentStruct queryFocusFlightFail = new MsgContentStruct("query_focus_flight_fail", "未查询到关注航班");

    public static MsgContentStruct pictureNotFound = new MsgContentStruct("picture_not_found", "找不到相应的图片信息");

    //shopping
    public static MsgContentStruct cabinIsSoldOut = new MsgContentStruct("cabin_is_sold_out", "非常抱歉，该舱位已售罄");
    public static MsgContentStruct cabinReturnIsSoldOut = new MsgContentStruct("cabin_return_is_sold_out", "非常抱歉，该舱位的返程已售罄");
    public static MsgContentStruct flightIsSoldOut = new MsgContentStruct("flight_is_sold_out", "非常抱歉，所有航班已售罄");
    public static MsgContentStruct flightReturnIsSoldOut = new MsgContentStruct("flight_return_is_sold_out", "非常抱歉，所有航班的返程已售罄");
    public static MsgContentStruct priceInfoIsNotFount = new MsgContentStruct("price_info_is_not_found", "抱歉，无法查询到相应的航线价格信息");
    public static MsgContentStruct noFlightToday = new MsgContentStruct("no_flight_today", "抱歉，该航线当天没有航班，请换个日期试试");
    public static MsgContentStruct policyIsInvalid = new MsgContentStruct("policy_is_invalid", "非常抱歉，此航线的优惠政策已失效，请重新预定");
    public static MsgContentStruct shoppingCheckFail = new MsgContentStruct("shopping_check_fail", "请求验证失败");

    //PE接口
    public static MsgContentStruct pe_noCheckInTicketById = new MsgContentStruct("pe_no_checkin_ticket", "该证件号没有可办理值机的客票!");
    public static MsgContentStruct pe_noGetCheckInTime = new MsgContentStruct("pe_no_get_checkin_time", "非常抱歉，您乘坐的航班尚未到值机时间。建议您在航班起飞前24小时内进行操作。!");
    public static MsgContentStruct pe_noBoardingPassInfo = new MsgContentStruct("pe_no_boardingpass_info", "未查到该登机牌信息!");
    public static MsgContentStruct pe_noCheckInCode = new MsgContentStruct("pe_no_checkin_code", "未查到该次值机验证码信息!");
    public static MsgContentStruct pe_checkInCodeFail = new MsgContentStruct("pe_checkin_code_fail", "值机验证码输入有误!");
    public static MsgContentStruct pe_checkInFailureIn40mins = new MsgContentStruct("pe_checkIn_failure_in40mis", "值机失败，飞机起飞前%s分钟内不允许值机!");
    public static MsgContentStruct pe_checkInFailure95557= new MsgContentStruct("pe_checkIn_failure_95557", "办理值机失败，请拨打95557进行确认");
    public static MsgContentStruct pe_checkInQrCodeFailure= new MsgContentStruct("pe_checkIn_qrcode", "办理值机成功，生成二维码电子登机牌失败");
    public static MsgContentStruct pe_checkInApplePassBook= new MsgContentStruct("pe_checkIn_passbook", "办理值机成功，生成wallet登机牌失败");
    public static MsgContentStruct pe_cancelCheckInFailure = new MsgContentStruct("pe_cancel_checkIn_failure", "取消值机失败，飞机起飞前60分钟内不允许取消值机!");
    public static MsgContentStruct pe_fltCannotCheckIn = new MsgContentStruct("pe_flt_cannot_check_in", "抱歉，当前航班无法办理在线值机");

    //订单
    public static MsgContentStruct psgTooMuch = new MsgContentStruct("psg_too_much", "乘客数量过多");
    public static MsgContentStruct psgNameError = new MsgContentStruct("psg_name_error", "您的订单中旅客姓名(%s)有误，请重新修改");
    public static MsgContentStruct contentIllegal = new MsgContentStruct("content_illegal", "%s不合法：%s");
    public static MsgContentStruct contentCanNotBeEmpty = new MsgContentStruct("content_can_not_be_empty", "%s不能为空");
    public static MsgContentStruct needSeparateBooking = new MsgContentStruct("need_separate_booking", "%s，需要分开预定");
    public static MsgContentStruct tooManyInsurance = new MsgContentStruct("too_many_insurance", "每个人在每个航程只能购买%d份航空意外险和%d份航空延误险");
    public static MsgContentStruct seatNotAvailable = new MsgContentStruct("seat_not_available", "非常抱歉，座位数已失效，请重新预定");
    public static MsgContentStruct faithlessPeople = new MsgContentStruct("faithless_people", "存在失信人，无法预定");
    public static MsgContentStruct cabinCombinationForbid = new MsgContentStruct("cabin_combination_forbid", "不可用的舱位组合");
    public static MsgContentStruct deptTimeLimit = new MsgContentStruct("dept_time_limit", "此航班离起飞时间小于%d分钟，无法预定");
    public static MsgContentStruct roundTripTimeLimit = new MsgContentStruct("round_trip_time_limit", "往返程航班的时间间隔不能小于%d分钟");
    public static MsgContentStruct orderNotExist = new MsgContentStruct("order_not_exist", "订单不存在");
    public static MsgContentStruct orderInProcessing = new MsgContentStruct("order_in_processing", "订单正在操作处理中，请稍后再试");
    public static MsgContentStruct orderStateCanNotIssue = new MsgContentStruct("order_state_can_not_issue", "当前订单无法出票：%s");
//    public static MsgContentStruct orderCanNotIssueDueToPayRecord = new MsgContentStruct("order_can_not_issue_due_to_pay_record", "当前订单无法出票，因为找不到支付成功的支付记录");
//    public static MsgContentStruct orderCanNotIssueDueToMistakeRefund = new MsgContentStruct("order_can_not_issue_due_to_mistake_refund", "当前订单无法出票，因为支付成功的记录已经提交差错退款");
    public static MsgContentStruct orderStateCanNotRefund = new MsgContentStruct("order_state_can_not_refund", "当前订单状态无法退票");
    public static MsgContentStruct ticketStateCanNotRefund = new MsgContentStruct("ticket_state_can_not_refund", "该票已使用或处于退票状态");
    public static MsgContentStruct refundTicketInfoNotFound = new MsgContentStruct("refund_ticket_info_not_found","非常抱歉，获取退票信息失败,请稍后再试");
    public static MsgContentStruct orderIssueFail = new MsgContentStruct("order_issue_fail", "出票失败");
    public static MsgContentStruct orderRefundFail = new MsgContentStruct("order_refund_fail", "退票失败");
    public static MsgContentStruct refundRateNotFound = new MsgContentStruct("refund_rate_not_found", "找不到相应的退票费率");
    public static MsgContentStruct orderCanNotMistakeRefundDueToPayRecord = new MsgContentStruct("order_can_not_mistake_refund_due_to_pay_record", "当前订单无法提交差错退款申请，因为找不到支付成功的支付记录");
    public static MsgContentStruct mistakeRefundApplyFail = new MsgContentStruct("mistake_refund_apply_fail", "提交差错退款失败");
    public static MsgContentStruct mistakeRefundAuditFail = new MsgContentStruct("mistake_refund_audit_fail", "差错退款审核失败");
    public static MsgContentStruct psgReOrder = new MsgContentStruct("psg_reorder", "旅客%s已经预定了航班%s，不能重复预定");
    public static MsgContentStruct priceFail = new MsgContentStruct("price_fail", "抱歉，价格有变动，请确认后重新提交订单");
    public static MsgContentStruct tooManyChildren = new MsgContentStruct("too_many_children", "一个成人最多带%s个儿童");
    public static MsgContentStruct internationalOnlySupportRefundAll = new MsgContentStruct("international_only_support_refund_all",
        "抱歉，目前APP上国际票仅支持全部退票。如有其他需求请联系客服处理");
    public static MsgContentStruct tooManyOrderWaitForPay = new MsgContentStruct("too_many_order_wait_for_pay", "抱歉，您未支付的订单过多，无法继续预定。未支付的订单已被作废。");
    public static MsgContentStruct tooManyOrderNotyPayCancel = new MsgContentStruct("too_many_order_not_pay_cancel", "抱歉，您未支付作废的订单过多，今天无法继续预定");
    public static MsgContentStruct inOrderBlackList = new MsgContentStruct("in_order_black_list", "抱歉，您暂时无法预定订单，请稍候再试");
    public static MsgContentStruct makeOrderFail = new MsgContentStruct("make_order_fail", "抱歉，生成订单失败：%s");
    public static MsgContentStruct orderCanNotPay = new MsgContentStruct("order_can_not_pay", "订单无法支付：%s");
    public static MsgContentStruct orderCanNotRefundDueToRule = new MsgContentStruct("order_can_not_refund_due_to_rule", "抱歉，由于退票规则限制，此订单无法退票");
    public static MsgContentStruct refundCheckTicketInfoChange = new MsgContentStruct("refund_check_ticket_info_change", "客票信息发生变更，请联系客户服务进行退票");

    //贵宾休息室
    public static MsgContentStruct vipRoomMakeTicketFail = new MsgContentStruct("vipRoomMakeTicketFail", "出票失败！");
    public static MsgContentStruct vipRoomTicketRefundStatusErr = new MsgContentStruct("vip_tickets_status_err", "贵宾休息券只有状态为‘未使用’才可执行此操作！");
    //我的行程接口
    public static MsgContentStruct myRoutInterfaceFail = new MsgContentStruct("myRout_interface_fail", "获取我的行程接口失败：%s");
    public static MsgContentStruct myRoutListIsNull = new MsgContentStruct("myRout_list_is_null", "没有行程记录，世界辣么大，我们去看看吧！");

    //优惠券
    public static MsgContentStruct couponAcceptPlatformErr = new MsgContentStruct("couponAcceptPlatformErr", "接入平台id错误！");
    public static MsgContentStruct couponAcceptPlatformUnuse = new MsgContentStruct("couponAcceptPlatformUnuse", "接入平台未启用！");
    public static MsgContentStruct couponNumZero = new MsgContentStruct("coupon_num_zero", "优惠券领取失败：%s");
    public static MsgContentStruct couponInvalid = new MsgContentStruct("coupon_invalid", "优惠券失效：%s");
    public static MsgContentStruct couponCannotUse = new MsgContentStruct("coupon_can_not_use", "优惠券不能使用：%s");
    public static MsgContentStruct couponCannotAuthentication = new MsgContentStruct("couponCannotAuthentication", "认证失败:%s");
    public static MsgContentStruct couponAlreadyUsed = new MsgContentStruct("coupon_already_used", "优惠券已使用");
    public static MsgContentStruct couponAuthenticateNotFound = new MsgContentStruct("coupon_authenticate_not_found", "未找到相应的认证信息");

    //保险
    public static MsgContentStruct insuranceInterfaceFail = new MsgContentStruct("insurance_interface_fail", "保险接口返回失败：%s");
    public static MsgContentStruct sinsuranceOrderStatusNotMatch = new MsgContentStruct("status_not_match", "保单当前状态 %s 无法进行此操作");
    public static MsgContentStruct refundFailExistNotSuccessInsuranceOrder = new MsgContentStruct("refund_fail_exist_not_success_insurance_order",
        "存在未投保成功的保单，暂时无法退票。请联系客服人员处理后再申请。");
    public static MsgContentStruct onlyDomesticInsuranceSupport = new MsgContentStruct("only_domestic_insurance_support", "抱歉，暂时只支持国内保险");
    public static MsgContentStruct tooOldBuyAviation = new MsgContentStruct("too_old_buy_aviation", "抱歉，超过%s周岁的旅客不能购买航意险");

    public static MsgContentStruct routeNotExist = new MsgContentStruct("route_not_exist", "航线不存在");
    public static MsgContentStruct priceCalendarNotComplete = new MsgContentStruct("price_calendar_not_complete", "价格日历数据不完整");
    //常用乘机人
    public static MsgContentStruct commonUserHasExist = new MsgContentStruct("commonUserHasExist", "该乘机人已存在！");
    public static MsgContentStruct commonUserTooMuch = new MsgContentStruct("commonUserTooMuch", "最多只能添加12个乘机人！");
    public static MsgContentStruct commonUserVerifyFail = new MsgContentStruct("commonUserVerifyFail", "常客信息验证失败！");

    //价格校验
    public static MsgContentStruct priceCheckErr = new MsgContentStruct("price_check_err", "价格校验失败，请重新预定");

    //IBE错误，待整理
    public static MsgContentStruct ibeErrMsg = new MsgContentStruct("ibe_err_msg", "%s");

    //特殊情况
    public static MsgContentStruct thirdPartyWsErr = new MsgContentStruct("third_party_ws_err", "");//第三方接口返回的错误信息，msg为第三方接口返回的错误内容
    //退票成人儿童
    public static MsgContentStruct refundAdtChdRatioErr = new MsgContentStruct("rfd_adt_chd_rate_err", "无法完成退票，儿童必须有成人陪伴，并且每个成人最多带%s个儿童");
    //参数长度校验
    public static MsgContentStruct parameterOutOfLength = new MsgContentStruct("parameter_out_of_length", "参数%s长度不能超过:%s");

    //ffp
    public static MsgContentStruct noExChangeFlt = new MsgContentStruct("no_exchange_flt", "抱歉，无法查询到可兑换的航班");
    public static MsgContentStruct exChangeOnlyDomestic = new MsgContentStruct("ex_change_only_domestic", "抱歉，目前免票兑换仅支持国内航班");
    public static MsgContentStruct realNameVerifyConditionsNeed = new MsgContentStruct("rn_verify_no_conditions", "您的账户中未留中文姓名或身份证号码，请携带本人有效身份证件原件前往厦航直销售票处办理");
    public static MsgContentStruct realNameVerifyMaxFailLimit = new MsgContentStruct("rn_verify_fail_limit", "您已累计认证错误%s次，请于%s小时后再次尝试操作");
    public static MsgContentStruct realNameVerifyMultipleCardNo = new MsgContentStruct("rn_verify_multiple_cardNo", "您的证件号码对应多个白鹭会员账户，请携带本人有效身份证件原件前往厦航直销售票处办理");
    public static MsgContentStruct unableSKTRetroAirCode = new MsgContentStruct("unable_skt_retro_airCode", "抱歉，目前暂时不支持代码为%s的航空公司的积分补登");
    public static MsgContentStruct unableSKTRetroFlightDate = new MsgContentStruct("unable_skt_retro_flightDate", "抱歉，航班时间不在积分补登的有效期内");

    //船套票
    public static MsgContentStruct flightDateError = new MsgContentStruct("flight_date_error", "抱歉，当前日期不可查询");
    public static MsgContentStruct flightFerryCantSearch = new MsgContentStruct("flight_ferry_cant_search", "抱歉，该航线航班时间暂未开放船票预定，请临近出发日期再来查询（船票日期在当前日期15日以内）");
    public static MsgContentStruct orderNoFlyToXmn = new MsgContentStruct("order_no_fly_to_xmn", "抱歉，该订单不是飞往厦门或为共享航班");
    public static MsgContentStruct ticketOrPsgError = new MsgContentStruct("ticket_or_psg_error", "抱歉，您的此订单票面状态不可用或您已购买船套票");
    public static MsgContentStruct orderPsgNumError = new MsgContentStruct("order_psg_num_error", "抱歉，订单人数不一致");
//    public static MsgContentStruct orderHasPaid = new MsgContentStruct("order_has_paid", "抱歉，订单已经支付，无法取消");
    public static MsgContentStruct orderTotalPriceError = new MsgContentStruct("order_total_price_error", "抱歉，订单总价不一致");
    public static MsgContentStruct orderSaveError = new MsgContentStruct("order_save_error", "抱歉，下单失败，请稍后尝试");
    public static MsgContentStruct addContactsError = new MsgContentStruct("add_contacts_error", "抱歉，添加乘客失败");
    public static MsgContentStruct contactsCanAddIsNullError = new MsgContentStruct("contacts_can_add_is_null_error", "抱歉，没有可添加的乘机人");
    public static MsgContentStruct contactsCanRefundIsNullError = new MsgContentStruct("contacts_can_refund_is_null_error", "抱歉，没有可退票的乘客");
    public static MsgContentStruct orderBePaidOrCanceled = new MsgContentStruct("order_be_paid_or_canceled", "抱歉，当前订单已取消或已支付");
    public static MsgContentStruct orderCancelError = new MsgContentStruct("order_cancel_error", "抱歉，订单取消失败，请稍后再试");
    public static MsgContentStruct orderPaidError = new MsgContentStruct("order_paid_error", "抱歉，订单支付成功，修改票面状态失败，请重新下单，等待退款");
    public static MsgContentStruct leftSeatNotEnough = new MsgContentStruct("left_seat_not_enough", "抱歉，剩余座位不足");
    public static MsgContentStruct flightIsInProcessing = new MsgContentStruct("flight_is_in_processing", "抱歉，锁定座位失败，请重试");
    public static MsgContentStruct cantRefundFerryTicketPassTime = new MsgContentStruct("cant_refund_ferry_ticket_pass_time", "抱歉，当前已过退票时间");
    public static MsgContentStruct cantRefundFerryOrderNoPaid = new MsgContentStruct("cant_refund_ferry_order_no_paid", "抱歉，该订单未支付");
    public static MsgContentStruct ferryOrderExistError = new MsgContentStruct("ferry_order_exist_error","如退机票会同时退游鼓浪屿订单，收手续费请参考相关产品退改期说明。您是否确认退票？");

    //电子钱包
    public static MsgContentStruct eWalletFeeVerifyError = new MsgContentStruct("eWallet_fee_verify_error","手续费校验失败，请重试.");
    public static MsgContentStruct eWalletLimitVerifyError = new MsgContentStruct("eWallet_limit_verify_error","抱歉，您的余额超过提现限额.");

  }

  public static class RequestErr{
    public static MsgContentStruct parameterCanNotBeEmpty = new MsgContentStruct("parameter_can_not_be_empty", "参数不能为空:%s");
    public static MsgContentStruct parameterFormatErr = new MsgContentStruct("parameter_format_err", "参数格式错误:%s");
    public static MsgContentStruct parameterContentErr = new MsgContentStruct("parameter_content_err", "参数内容错误:%s");
    public static MsgContentStruct requestMethodErr = new MsgContentStruct("request_method_err", "请求方法错误，支持的类型：%s");
    public static MsgContentStruct urlError = new MsgContentStruct("url_error", "请求的url错误");
    public static MsgContentStruct appTypeNotFound = new MsgContentStruct("app_type_not_found", "找不到客户端系统信息");
    public static MsgContentStruct appVersionNotFound = new MsgContentStruct("app_version_not_found", "找不到客户端应用版本信息");

    //授权相关
    public static MsgContentStruct accessTokenExpired = new MsgContentStruct("access_token_expired", "accessToken过期:%s");
    public static MsgContentStruct refreshTokenExpired = new MsgContentStruct("refresh_token_expired", "refreshToken过期");
    public static MsgContentStruct requestVerifyFail = new MsgContentStruct("request_verify_fail", "请求验证失败:%s");
    public static MsgContentStruct needGetPublicKeyFirst = new MsgContentStruct("need_get_public_key_first", "需要先获取publicKey");
  }

  public static class FfpErr {
    public static HashMap<String, MsgContentStruct> hm;

    static {
      hm = new HashMap<>();
      hm.put("MEM001", new MsgContentStruct("ffp_join_channel_err", "入会渠道错误"));
      hm.put("MEM002", new MsgContentStruct("ffp_password_cannot_empty", "密码不能为空"));
      hm.put("MEM003", new MsgContentStruct("ffp_certificate_no_cannot_empty", "证件号不能为空"));
      hm.put("MEM004", new MsgContentStruct("ffp_certificate_with_stock_card_no_err", "该证件信息对应的存量用户的白鹭卡号格式错"));
      hm.put("MEM005", new MsgContentStruct("ffp_card_no_err", "白鹭卡号输入有误"));
      hm.put("MEM006", new MsgContentStruct("ffp_table_no_err", "申请表号错误"));
      hm.put("MEM007", new MsgContentStruct("ffp_china_name_err", "中文姓名错误"));
      hm.put("MEM008", new MsgContentStruct("ffp_last_Name_err", "英文姓错误"));
      hm.put("MEM009", new MsgContentStruct("ffp_first_Name_err", "英文名错误"));
      hm.put("MEM010", new MsgContentStruct("ffp_phone_no_err", "手机号错"));
      hm.put("MEM011", new MsgContentStruct("ffp_email_err", "邮箱地址错"));
      hm.put("MEM012", new MsgContentStruct("ffp_certificate_type_err", "证件类型出错"));
      hm.put("MEM013", new MsgContentStruct("ffp_certificate_no_err", "证件号码错误"));
      hm.put("MEM014", new MsgContentStruct("ffp_sex_err", "性别与身份证不符"));
      hm.put("MEM015", new MsgContentStruct("ffp_too_young_to_join", "未满12岁不能入会"));
      hm.put("MEM016", new MsgContentStruct("ffp_too_old_to_apply_grow_up_card", "超过23岁不可以办理白鹭成长卡"));
      hm.put("MEM017", new MsgContentStruct("ffp_apply_date_err", "申请日期错误"));
      hm.put("MEM018", new MsgContentStruct("ffp_birthday_not_consistent_with_document", "出生日期和身份证不匹配"));
      hm.put("MEM019", new MsgContentStruct("ffp_certificate_no_already_exist", "证件号已经存在"));
      hm.put("MEM020", new MsgContentStruct("ffp_card_no_already_exist", "白鹭卡已存在"));
      hm.put("MEM021", new MsgContentStruct("ffp_certificate_no_is_stock", "该证件号为存量用户"));
      hm.put("MEM022", new MsgContentStruct("ffp_egret_card_no_and_user_name_is_empty", "白鹭卡号和B2C用户名都为空"));
      hm.put("MEM023", new MsgContentStruct("ffp_b2c_user_name_err", "B2C用户名错误"));
      hm.put("MEM024", new MsgContentStruct("ffp_b2c_user_update_fail", "B2C用户更新失败"));
      hm.put("MEM025", new MsgContentStruct("ffp_egret_card_no_not_exist", "卡号不存在"));
      hm.put("MEM026", new MsgContentStruct("ffp_egret_card_already_calcel", "卡号已注销"));
      hm.put("MEM027", new MsgContentStruct("ffp_address_type_err", "地址类型错误"));
      hm.put("MEM028", new MsgContentStruct("ffp_egret_card_create_err", "生成卡号失败"));
      hm.put("MEM029", new MsgContentStruct("ffp_modify_channel_and_type_cannot_empty", "修改渠道和修改类别不能为空"));
      hm.put("MEM030", new MsgContentStruct("ffp_get_operator_info_fail", "获取操作人员信息失败"));
      hm.put("MEM031", new MsgContentStruct("ffp_identity_length_err", "身份证位数不正确"));
      hm.put("MEM032", new MsgContentStruct("ffp_most_one_email", "邮寄地址必须唯一"));
      hm.put("MEM033", new MsgContentStruct("ffp_most_one_home_address", "最多只能填写一个家庭地址"));
      hm.put("MEM098", new MsgContentStruct("ffp_update_fail", "更新失败"));
    }


//    public static MsgContentStruct getMsgContentStruct(String ffpErrCode){
//      return hm.get(ffpErrCode);
//    }
    }

  public static class PeErr {
    public static HashMap<Long, MsgContentStruct> hm;

    static {
      hm = new HashMap<>();
      //公共
//      hm.put((long) -1000, new MsgContentStruct("pe_remote_server_connect_err", "远程服务连接失败"));
//      hm.put((long) -1001, new MsgContentStruct("pe_remote_server_msg_parse_err", "远程服务报文解析失败"));
//      hm.put((long) -1002, new MsgContentStruct("pe_remote_server_invoke_err", "远程服务调用失败"));
//      hm.put((long) -1003, new MsgContentStruct("pe_account_not_have_this_dept", "账号未配置该始发站"));
//      hm.put((long) -1004, new MsgContentStruct("pe_ip_not_have_auth", "请求的IP地址未配置权限"));
//      hm.put((long) -1005, new MsgContentStruct("pe_login_err", "登录失败"));
//      hm.put((long) -1006, new MsgContentStruct("pe_server_verify_err", "底层服务校验失败"));
//      hm.put((long) -1007, new MsgContentStruct("pe_request_para_is_null", "请求参数不能用空值"));
//      hm.put((long) -1008, new MsgContentStruct("pe_over_max_connections", "超过最大访问连接数"));
      //region detrTicket
      hm.put((long) -200001, new MsgContentStruct("pe_certificate_no_err", "证件号输入有误"));
      hm.put((long) -200002, new MsgContentStruct("pe_certificate_type_err", "证件类型输入有误"));
      hm.put((long) -300001, new MsgContentStruct("pe_no_avail_tickets", "未查到可用客票"));
      hm.put((long) -300002, new MsgContentStruct("pe_one_cert_more_name", "同一证件号对应多个姓名（可配置），请使用客票号值机"));
      hm.put((long) -300003, new MsgContentStruct("pe_no_reach_time", "旅客行程未到可办理时间"));
      hm.put((long) -900001, new MsgContentStruct("pe_get_detr_return_err", "提取票面返回异常"));
      //endregion

      //region doSYPR
      hm.put((long) -200101, new MsgContentStruct("pe_flt_date_err", "航班日期输入有误"));
      hm.put((long) -200102, new MsgContentStruct("pe_flt_no_err", "航班号输入有误"));
      hm.put((long) -200103, new MsgContentStruct("pe_flt_dep_city_err", "起飞城市输入有误"));
      hm.put((long) -200104, new MsgContentStruct("pe_flt_arr_city_err", "到达城市输入有误"));
      hm.put((long) -200105, new MsgContentStruct("pe_ticket_no_err", "票号输入有误"));
      hm.put((long) -300101, new MsgContentStruct("pe_forbid_route_rule", "未通过禁办航班航线规则"));
      hm.put((long) -300102, new MsgContentStruct("pe_flt_no_init", "航班未初始化"));
      hm.put((long) -300103, new MsgContentStruct("pe_no_support_family_psg", "不支持家族旅客"));
      hm.put((long) -300104, new MsgContentStruct("pe_no_support_stcr_psg", "不支持担架旅客"));
      hm.put((long) -300105, new MsgContentStruct("pe_no_support_inft_psg", "不支持带婴儿的旅客"));
      hm.put((long) -300106, new MsgContentStruct("pe_no_support_chld_psg", "不支持儿童旅客(可配置)"));
      hm.put((long) -300107, new MsgContentStruct("pe_no_support_mail_seat", "不支持信袋占座"));
      hm.put((long) -300108, new MsgContentStruct("pe_no_support_ssr", "不支持该特服项"));
      hm.put((long) -300109, new MsgContentStruct("pe_no_support_airline", "不支持该航空公司"));
      hm.put((long) -300110, new MsgContentStruct("pe_flt_not_allow_query_psg", "该航班不允许查询航班旅客功能"));
      hm.put((long) -300111, new MsgContentStruct("pe_route_not_allow_query_psg", "该航线不允许查询航班旅客功能"));
      hm.put((long) -300112, new MsgContentStruct("pe_before_checkin_time", "抱歉，还未到达允许的办理时间"));
      hm.put((long) -300113, new MsgContentStruct("pe_after_checkin_time", "抱歉，已经超过允许的办理时间"));
      hm.put((long) -300114, new MsgContentStruct("pe_not_exist_psg", "旅客记录不存在"));
      hm.put((long) -300115, new MsgContentStruct("pe_no_support_special_food_psg", "不支持特殊餐食物旅客"));
      hm.put((long) -900101, new MsgContentStruct("pe_query_flt_psg_info_err", "查询航班旅客信息返回异常"));
      hm.put((long) -900102, new MsgContentStruct("pe_query_flt_forbid_rule_err", "查询航班禁办规则返回异常"));
      hm.put((long) -900103, new MsgContentStruct("pe_query_psg_info_err", "查询旅客信息返回异常"));
      //endregion

      //region querySeatChart
      hm.put((long) -200301, new MsgContentStruct("pe_flt_dep_airport_err", "出发航站输入有误"));
      hm.put((long) -200302, new MsgContentStruct("pe_cabin_type_err", "舱位输入有误"));
      hm.put((long) -200303, new MsgContentStruct("pe_flt_date_err", "航班日期输入有误"));
      hm.put((long) -200304, new MsgContentStruct("pe_flt_no_err", "航班号输入有误"));
      hm.put((long) -200305, new MsgContentStruct("pe_flt_arr_airport_err", "到达航站输入有误"));
      hm.put((long) -300301, new MsgContentStruct("pe_flt_no_init", "航班未初始化"));
      hm.put((long) -300302, new MsgContentStruct("pe_flt_protected_mode", "航班保护状态"));
      hm.put((long) -900301, new MsgContentStruct("pe_query_seatmap_return_err", "查询座位图返回异常"));
      //endregion

      //region doPsrCheckin
      hm.put((long) -200501, new MsgContentStruct("pe_flt_no_err", "航班号输入有误"));
      hm.put((long) -200502, new MsgContentStruct("pe_flt_date_err", "航班日期输入有误"));
      hm.put((long) -200503, new MsgContentStruct("pe_seat_no_or_fav_err", "座位号或偏好输入有误"));
      hm.put((long) -200504, new MsgContentStruct("pe_is_must_asr_err", "是否强制预留输入有误"));
      hm.put((long) -200505, new MsgContentStruct("pe_pre_seat_no_err", "预留座位号输入有误"));
      hm.put((long) -200506, new MsgContentStruct("pe_flt_arr_airport_err", "到达航站输入有误"));
      hm.put((long) -200507, new MsgContentStruct("pe_flt_dep_airport_err", "出发航站输入有误"));
      hm.put((long) -200508, new MsgContentStruct("pe_ffp_no_err", "常客卡号输入有误"));
      hm.put((long) -200509, new MsgContentStruct("pe_ffp_airline_err", "常客卡航空公司输入有误"));
      hm.put((long) -200510, new MsgContentStruct("pe_psg_gender_err", "性别输入有误"));
      hm.put((long) -200511, new MsgContentStruct("pe_ticket_no_err", "票号输入有误"));
      hm.put((long) -200512, new MsgContentStruct("pe_travel_no_err", "行程序号输入有误"));
      hm.put((long) -200513, new MsgContentStruct("pe_psg_record_no_eixst", "旅客记录不存在"));
      hm.put((long) -300501, new MsgContentStruct("pe_flt_no_init", "航班未初始化"));
      hm.put((long) -300502, new MsgContentStruct("pe_no_allow_change_bag", "不允许修改行李"));
      hm.put((long) -300503, new MsgContentStruct("pe_allow_checkin_time", "指定时间（HHMM）后允许值机"));
      hm.put((long) -300504, new MsgContentStruct("pe_connflt_checkin_cannot_use", "联程值机不能使用"));
      hm.put((long) -300505, new MsgContentStruct("pe_manual_checkin_err", "人工值机问题"));
      hm.put((long) -300506, new MsgContentStruct("pe_over_craft_limit", "超出额外的机组限制数"));
      hm.put((long) -300507, new MsgContentStruct("pe_extra_flt_limit", "额外机组不能有已分配的额外座位"));
      hm.put((long) -300508, new MsgContentStruct("pe_psg_name_too_long", "旅客姓名过长"));
      hm.put((long) -300509, new MsgContentStruct("pe_flt_middle_close", "航班已经中间关闭"));
      hm.put((long) -300510, new MsgContentStruct("pe_flt_already_cancel", "航班已经取消"));
      hm.put((long) -300511, new MsgContentStruct("pe_flt_already_close", "航班已经关闭"));
      hm.put((long) -300512, new MsgContentStruct("pe_error_asr_seat", "不正确的预定座位"));
      hm.put((long) -300513, new MsgContentStruct("pe_no_time_reach_boarding_gate", "到达登机口区域的时间不足"));
      hm.put((long) -300514, new MsgContentStruct("pe_change_make_psg_waiting", "修改会引起旅客候补"));
      hm.put((long) -300515, new MsgContentStruct("pe_old_seat_request_cannot_change", "原始的座位请求不能更改"));
      hm.put((long) -300516, new MsgContentStruct("pe_psg_already_checkin", "旅客已经办理值机"));
      hm.put((long) -300517, new MsgContentStruct("pe_connflt_protected_mode", "航班保护状态"));
      hm.put((long) -300518, new MsgContentStruct("pe_connflt_second_seg_full", "联程值机第二段座位已满"));
      hm.put((long) -300519, new MsgContentStruct("pe_connflt_seg_checkin_order_err", "联程航段值机顺序错误"));
      hm.put((long) -300527, new MsgContentStruct("pe_mail_addr_err", "邮箱输入有误"));
      hm.put((long) -300528, new MsgContentStruct("pe_ffp_service_err", "常客卡服务调用失败"));
      hm.put((long) -300529, new MsgContentStruct("pe_seat_no_not_exist", "座位号不存在"));
      hm.put((long) -300530, new MsgContentStruct("pe_seat_already_occupied", "座位号已经被占用"));
      hm.put((long) -900501, new MsgContentStruct("pe_asr_seat_return_err", "预占座位返回异常"));
      hm.put((long) -900502, new MsgContentStruct("pe_query_seatmap_return_err", "查询座位图返回异常"));
      hm.put((long) -900503, new MsgContentStruct("pe_query_psg_info_return_err", "查询旅客信息返回异常"));
      hm.put((long) -900504, new MsgContentStruct("pe_checkin_return_err", "值机服务返回异常"));

      hm.put((long) -202101, new MsgContentStruct("pe_broad_data_stream_fail", "登机牌数据流有误"));
      hm.put((long) -902101, new MsgContentStruct("pe_get_ebroadpass_fail", "获取电子登机牌出现异常"));
      //endregion

      //region doDelPsr
      hm.put((long) -200701, new MsgContentStruct("pe_flt_no_err", "航班号输入有误"));
      hm.put((long) -200702, new MsgContentStruct("pe_flt_date_err", "航班日期输入有误"));
      hm.put((long) -200703, new MsgContentStruct("pe_flt_arr_airport_err", "到达航站输入有误"));
      hm.put((long) -200704, new MsgContentStruct("pe_flt_dep_airport_err", "出发航站输入有误"));
      hm.put((long) -200705, new MsgContentStruct("pe_certificate_no_err", "证件号输入有误"));
      hm.put((long) -200706, new MsgContentStruct("pe_certificate_type_err", "证件类型输入有误"));
      hm.put((long) -300701, new MsgContentStruct("pe_fobidden_route_rule", "未通过禁办航班航线规则"));
      hm.put((long) -300702, new MsgContentStruct("pe_flt_no_init", "航班未初始化"));
      hm.put((long) -300703, new MsgContentStruct("pe_no_support_family_psg", "不支持家族旅客!"));
      hm.put((long) -300704, new MsgContentStruct("pe_no_support_stcr_psg", "不支持担架旅客。"));
      hm.put((long) -300705, new MsgContentStruct("pe_no_support_inft_psg", "不支持带婴儿的旅客。"));
      hm.put((long) -300706, new MsgContentStruct("pe_no_support_chld_psg", "不支持儿童旅客。"));
      hm.put((long) -300707, new MsgContentStruct("pe_no_support_mail_seat", "不支持信袋占座。"));
      hm.put((long) -300708, new MsgContentStruct("pe_no_support_ssr", "不支持该特服项!"));
      hm.put((long) -300709, new MsgContentStruct("pe_no_support_airline", "不支持该航空公司"));
      hm.put((long) -300710, new MsgContentStruct("pe_flt_not_allow_query_psg", "该航班不允许查询航班旅客功能!"));
      hm.put((long) -300711, new MsgContentStruct("pe_route_not_allow_query_psg", "该航线不允许查询航班旅客功能!"));
      hm.put((long) -300712, new MsgContentStruct("pe_before_checkin_time", "抱歉，还未到达允许的办理时间"));
      hm.put((long) -300713, new MsgContentStruct("pe_after_checkin_time", "抱歉，已经超过允许的办理时间"));
      hm.put((long) -300714, new MsgContentStruct("pe_no_avail_tickets", "未查到可用客票"));
      hm.put((long) -300715, new MsgContentStruct("pe_one_cert_more_name", "同一证件号对应多个姓名，请使用客票号值机"));
      hm.put((long) -300716, new MsgContentStruct("pe_no_auth_to_cancel_checkin", "该用户对没有对该航空公司的旅客进行取消值机的权限!"));
      hm.put((long) -300717, new MsgContentStruct("pe_no_auth_drop_down_psg", "该用户没有拉下旅客的权限"));
      hm.put((long) -300718, new MsgContentStruct("pe_psg_info_not_equal_before", "该旅客和接收时信息不一致，不能被拉下！"));
      hm.put((long) -300719, new MsgContentStruct("pe_already_cancel", "该旅客状态为已取消值机"));
      hm.put((long) -300720, new MsgContentStruct("pe_more_cancel_times", "该用户对旅客取消值机次数太多"));
      hm.put((long) -300721, new MsgContentStruct("pe_flt_not_allow_cancel", "该航班现在已经不能取消值机"));
      hm.put((long) -300722, new MsgContentStruct("pe_psg_not_get_in", "旅客未被接收"));
      hm.put((long) -300723, new MsgContentStruct("pe_flt_middle_close", "航班已经中间关闭"));
      hm.put((long) -300724, new MsgContentStruct("pe_no_time_reach_boarding_gate", "到达登机口区域的时间不足"));
      hm.put((long) -300725, new MsgContentStruct("pe_flt_already_close", "航班已经关闭"));
      hm.put((long) -300726, new MsgContentStruct("pe_already_boarding", "已经开始本地登机，不允许再删除旅客"));
      hm.put((long) -300728, new MsgContentStruct("pe_not_self_channel", "非自助渠道值机，请到机场人工值机柜台办理取消值机手续"));
      hm.put((long) -300729, new MsgContentStruct("pe_psg_has_bag", "您有托运行李，请到机场人工值机柜台办理取消值机手续"));
      hm.put((long) -300730, new MsgContentStruct("pe_xres_psg", "XRES 旅客，请到机场人工值机柜台办理取消值机手续"));
      hm.put((long) -300731, new MsgContentStruct("pe_flt_status_not_allow", "航班状态不可办理"));
      hm.put((long) -300732, new MsgContentStruct("pe_check_code_err", "值机校验码输入有误"));
      hm.put((long) -300733, new MsgContentStruct("pe_drop_psg_has_child", "拉下的主旅客含有未拉下的儿童"));
      hm.put((long) -900701, new MsgContentStruct("pe_query_psg_info_return_err", "查询航班旅客信息返回异常"));
      hm.put((long) -900702, new MsgContentStruct("pe_query_forbidden_flt_return_err", "查询禁办航班规则返回异常"));
      hm.put((long) -900703, new MsgContentStruct("pe_psg_info_return_err", "查询旅客信息返回异常"));
      hm.put((long) -900704, new MsgContentStruct("pe_get_detr_return_err", "提取票面返回异常"));
      hm.put((long) -900705, new MsgContentStruct("pe_query_ssr_return_err", "提取特殊信息返回异常"));
      hm.put((long) -900706, new MsgContentStruct("pe_cancel_checkin_return_err", "取消值机服务返回异常"));
      //endregion

      //weather
      hm.put((long) -200601, new MsgContentStruct("pe_city_code_err", "航站输入有误"));
      hm.put((long) -900601, new MsgContentStruct("pe_query_weather_return_err", "天气服务返回异常"));

      //queryFlightBoardInAirport
      hm.put((long) -200801, new MsgContentStruct("pe_flt_no_input_err", "航班号输入有误"));
      hm.put((long) -200802, new MsgContentStruct("pe_flt_date_input_err", "航班日期输入有误"));
      hm.put((long) -200803, new MsgContentStruct("pe_dept_airport_input_err", "出发航站输入有误"));
      hm.put((long) -300801, new MsgContentStruct("pe_flt_not_init", "航班未初始化"));
      hm.put((long) -300802, new MsgContentStruct("pe_flt_status_cannot_work", "航班状态不可办理"));
      hm.put((long) -300803, new MsgContentStruct("pe_flt_already_control", "航班已经被控制"));
      hm.put((long) -900801, new MsgContentStruct("pe_query_flt_info_return_err", "查询航班信息返回异常"));
    }

  }

  public static class PayErr {
    public static HashMap<String, MsgContentStruct> hm;

    static {
      hm = new HashMap<>();
      hm.put("900001", new MsgContentStruct("pay_para_err", "请求参数错误"));
      hm.put("900002", new MsgContentStruct("pay_illegal_request", "非法请求"));
      hm.put("988888", new MsgContentStruct("pay_inner_sys_timeout", "内部系统超时"));
//      hm.put("999999", new MsgContentStruct("pay_sys_exception", "系统异常"));//999999时会包含各种异常
      hm.put("600000", new MsgContentStruct("pay_para_cannot_null", "参数不能为空"));
      hm.put("600001", new MsgContentStruct("pay_api_not_exist", "接口不存在"));
      hm.put("600002", new MsgContentStruct("pay_illegal_para", "参数非法"));
      hm.put("600003", new MsgContentStruct("pay_signature_valid_err", "签名效验错误"));
      hm.put("600010", new MsgContentStruct("pay_create_payorder_err", "创建支付订单异常"));
      hm.put("600011", new MsgContentStruct("pay_payorder_timeout", "支付订单超时关闭"));
      hm.put("600020", new MsgContentStruct("pay_card_info_input_err", "卡信息输入异常"));
      hm.put("600021", new MsgContentStruct("pay_card_valid_err", "卡信息认证未通过"));
      hm.put("600022", new MsgContentStruct("pay_card_not_support_err", "卡种不支持异常"));
      hm.put("600030", new MsgContentStruct("pay_channel_cannot_use_err", "支付通道不可用异常"));
      hm.put("605001", new MsgContentStruct("pay_refund_status_err", "退款原交易状态异常"));
      hm.put("605002", new MsgContentStruct("pay_refund_orgin_order_notexist", "退款原交易不存在"));
      hm.put("605003", new MsgContentStruct("pay_refund_already_exist", "退款已经存在不允许退款"));
      hm.put("605004", new MsgContentStruct("pay_refund_over_amount", "退款可退金额超限"));
      hm.put("605005", new MsgContentStruct("pay_refund_type_err", "退款类型错误"));
      hm.put("605006", new MsgContentStruct("pay_refund_amount_err", "退款金额错误"));
      hm.put("605007", new MsgContentStruct("pay_refund_request_not_match", "退款请求和原交易业务方不匹配"));
      hm.put("605008", new MsgContentStruct("pay_create_refund_request_err", "创建退款请求异常"));
      hm.put("605009", new MsgContentStruct("pay_refund_request_err", "退款请求异常"));
      hm.put("411001", new MsgContentStruct("pay_no_auth_err", "无此权限，请联系银行或平台"));
      hm.put("411003", new MsgContentStruct("pay_card_overlimit_err", "该卡超过限额"));
      hm.put("411022", new MsgContentStruct("pay_card_nosupport_err", "该卡不支持无卡支付，请联系发卡方开通"));
      hm.put("411041", new MsgContentStruct("pay_over_single_amount_err", "单笔金额超限"));
      hm.put("411042", new MsgContentStruct("pay_over_month_amount_err", "月累计金额超限"));
      hm.put("411043", new MsgContentStruct("pay_cannot_find_record_err", "没有找到相应交易记录"));
      hm.put("411044", new MsgContentStruct("pay_process_err", "交易失败"));
      hm.put("411045", new MsgContentStruct("pay_check_certid_err", "请您确认身份证件号是否填写正确"));
      hm.put("411046", new MsgContentStruct("pay_trade_limit_err", "交易受限"));
      hm.put("411047", new MsgContentStruct("pay_certid_not_match_name_err", "身份证与姓名不匹配"));
      hm.put("411048", new MsgContentStruct("pay_certid_isnull", "证件号码为空"));
      hm.put("411049", new MsgContentStruct("pay_mobilenum_isnull", "手机号为空"));
      hm.put("411050", new MsgContentStruct("pay_name_isnull", "姓名为空"));
      hm.put("411051", new MsgContentStruct("pay_over_company_day_limit", "超过商户日交易限额"));
      hm.put("411052", new MsgContentStruct("pay_over_company_day_countlimit", "超过商户日交易笔数"));
      hm.put("411053", new MsgContentStruct("pay_public_account_err", "对公账户代扣支付失败"));
      hm.put("411054", new MsgContentStruct("pay_name_input_err", "输入姓名有误"));
      hm.put("411055", new MsgContentStruct("pay_unknown_err", "未知错误"));
      hm.put("411056", new MsgContentStruct("pay_card_owner_valid_err", "持卡人鉴权失败，请重新核对信息"));
      hm.put("411057", new MsgContentStruct("pay_card_exception", "银行卡异常，请联系发卡银行"));
      hm.put("411058", new MsgContentStruct("pay_platform_code_err", "平台代码无效"));
      hm.put("411059", new MsgContentStruct("pay_request_para_err", "请求参数错误"));
      hm.put("411060", new MsgContentStruct("pay_nosupport_bank_err", "不支持的银行"));
      hm.put("411061", new MsgContentStruct("pay_noavail_channel_err", "没有可用的通道"));
      hm.put("411062", new MsgContentStruct("pay_bank_state_err", "银行状态异常"));
      hm.put("411063", new MsgContentStruct("pay_nosupport_trade_type_err", "不支持的交易类型"));
      hm.put("411064", new MsgContentStruct("pay_bank_code_err", "银行编码有误"));
      hm.put("411065", new MsgContentStruct("pay_repeat_request_err", "重复的请求"));
      hm.put("411066", new MsgContentStruct("pay_trade_order_noexist_err", "原交易订单不存在"));
      hm.put("411067", new MsgContentStruct("pay_order_state_nosupport_err", "原交易订单状态不支持此请求"));
      hm.put("411068", new MsgContentStruct("pay_orderdata_not_match_err", "原交易订单数据与当前请求不匹配"));
      hm.put("411069", new MsgContentStruct("pay_illegal_request_err", "非法请求"));
      hm.put("411070", new MsgContentStruct("pay_bank_inprocess_err", "银行处理中，请勿重复操作"));
      hm.put("411071", new MsgContentStruct("pay_bankroute_fail_err", "银行路由失败"));
      hm.put("411072", new MsgContentStruct("pay_trade_notfound_err", "原交易未找到或者已经处理"));
      hm.put("411101", new MsgContentStruct("pay_query_card_company_err", "查发卡方失败，请联系发卡银行"));
      hm.put("411103", new MsgContentStruct("pay_company_notallow_err", "本卡在该商户不允许此交易，请联系收单机构"));
      hm.put("411104", new MsgContentStruct("pay_card_illegal_err", "本卡被发卡方没收，请联系发卡银行"));
      hm.put("411105", new MsgContentStruct("pay_card_owner_invalid_err", "持卡人认证失败，请重新核对信息"));
      hm.put("411106", new MsgContentStruct("pay_request_inprocess_err", "请求正在处理中"));
      hm.put("411107", new MsgContentStruct("pay_invalid_response_err", "无效应答"));
      hm.put("411108", new MsgContentStruct("pay_not_doanything_err", "不作任何处理"));
      hm.put("411110", new MsgContentStruct("pay_error_err", "支付失败，请联系发卡银行"));
      hm.put("411112", new MsgContentStruct("pay_error2_err", "支付失败，请稍候重试"));
      hm.put("411113", new MsgContentStruct("pay_over_limit_err", "交易超限，请联系发卡银行"));
      hm.put("411114", new MsgContentStruct("pay_invalid_cardno_err", "无效卡号，请核对重新输入"));
      hm.put("411121", new MsgContentStruct("pay_card_noinit_err", "本卡未初始化，请联系发卡银行"));
      hm.put("411130", new MsgContentStruct("pay_msg_type_err", "报文格式错误，请联系收单机构"));
      hm.put("411134", new MsgContentStruct("pay_card_illegal_err", "该卡有作弊嫌疑或有相关限制，请联系发卡银行"));
      hm.put("411135", new MsgContentStruct("pay_cvn_valid_err", "CVN验证失败或有作弊嫌疑"));
      hm.put("411138", new MsgContentStruct("pay_pwd_err_overlimit_err", "密码错误次数超限，请联系发卡银行"));
      hm.put("411140", new MsgContentStruct("pay_request_err", "请求失败，请联系收单机构"));
      hm.put("411151", new MsgContentStruct("pay_notenough_amount_err", "可用余额不足，请联系发卡银行"));
      hm.put("411152", new MsgContentStruct("pay_overdue_card_err", "过期的卡"));
      hm.put("411153", new MsgContentStruct("pay_rush_err", "冲正成功"));
      hm.put("411154", new MsgContentStruct("pay_overdue_err", "该卡已过期，请联系发卡银行"));
      hm.put("411155", new MsgContentStruct("pay_pwd_check_err", "密码验证失败，请重新输入"));
      hm.put("411161", new MsgContentStruct("pay_amount_overlimit_err", "消费金额超限，请联系发卡银行"));
      hm.put("411165", new MsgContentStruct("pay_daylimit_err", "单日消费次数超限，请联系发卡银行"));
      hm.put("499001", new MsgContentStruct("pay_cardstate_useless_err", "账户状态无效"));
      hm.put("499002", new MsgContentStruct("pay_order_notsupport_refund_err", "该订单不支持退款"));
      hm.put("499003", new MsgContentStruct("pay_refund_overamount_err", "退款金额超限"));
      hm.put("499004", new MsgContentStruct("pay_notenough_money_err", "余额不足"));
      hm.put("499005", new MsgContentStruct("pay_order_notexist_err", "订单不存在"));
      hm.put("499006", new MsgContentStruct("pay_his_order_notopen_err", "历史退款未开通"));
      hm.put("499007", new MsgContentStruct("pay_iplimit_err", "IP限制"));
      hm.put("499008", new MsgContentStruct("pay_bank_refund_err", "银行退款失败"));

    }
  }
}

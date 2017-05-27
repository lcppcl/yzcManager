package com.common.result;

/**
 * Created by wangfujie on 2017/4/16.
 */
public class MessageCode {
    public static class Common {
        public final static int SUCCESS = 906;//操作成功
        public final static int NO_RESULT = 911;//查询无结果
        public final static int OPERATION_RESTRICT = 912;//操作限制
        public final static int PARAM_ISNULL = 913;//参数不能为空
        public final static int CAN_NOT_UPDATE = 914;//不能进行删除
    }

    public static class User {
        public final static int NOT_ROLE = 102;//没有任何角色
        public final static int ERROR_COUNT = 103;//账号不存在
        public final static int ERROR_PWD = 104;//密码错误
        public final static int NOT_PRIVILEGE = 105;//没有操作权限
        public final static int NOT_LOGIN = 106;//此操作需要登录后进行
    }
}

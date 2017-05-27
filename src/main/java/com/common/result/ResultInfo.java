package com.common.result;

/**
 * Created by wangfujie on 2017/4/16.
 * 结果信息
 */
public class ResultInfo {

    /**
     * 提示码
     */
    private int messageCode;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回结果
     */
    private Object result;

    public ResultInfo(){}

    public ResultInfo(int messageCode){
        setMessageCode(messageCode);
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
        switch (messageCode){
            case 900:
                setMessage("未知错误！");break;
            case 901:
                setMessage("操作失败！");break;
            case 906:
                setMessage("操纵成功！");break;
            case 911:
                setMessage("查询无结果！");break;
            case 912:
                setMessage("操作限制！");break;
            case 913:
                setMessage("参数不能为空！");break;
            case 914:
                setMessage("不能进行删除！");break;
            case 102:
                setMessage("没有任何角色！");break;
            case 103:
                setMessage("账号不存在！");break;
            case 104:
                setMessage("密码错误！");break;
            case 105:
                setMessage("没有操作权限！");break;
            case 106:
                setMessage("需要登录后进行！");break;
            default:
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

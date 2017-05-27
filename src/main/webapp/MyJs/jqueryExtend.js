/**
 * Created by wangfujie on 2017/4/29.
 */
//收集form表单数据成Object对象
(function($){
    $.fn.extend({
        serializeObject:function(){
            if(this.length>1){
                return false;
            }
            var arr=this.serializeArray();
            var obj=new Object;
            $.each(arr,function(k,v){
                obj[v.name]=v.value;
            });
            return obj;
        }
    });
})(jQuery);
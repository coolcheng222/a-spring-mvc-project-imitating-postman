
class Request{
    url;
    method;
    params;
    cookies;
    headers;
    json;
    isJson;
}


function responseDiv(str){
    return $(`<figure class="highlight"></figure>`).append(str);
}


$(function () {
    var submiting = function(key){
        if(!key.hasOwnProperty("keyCode") || key.keyCode == 13){

            //清空响应
            $(".response").empty();
            //构建请求
            let form = $("#post-info");
            request = forRequest(form, getKVObject);
            $.ajax({
                url: "post",
                type:"post",
                contentType:"application/json",
                success:function(result){
                    $("#formatted_div").append(responseDiv(result.formatted));
                    $("#raw_div").append(responseDiv(result.entity));
                    $("#rheaders_div").append(renderTable(result.header));
                    $('#status_div').append(renderTable(result.statusLine))
                },

                data:JSON.stringify(request)
            });
            return false;
        }
    }
    //取消输入框的回车默认行为
    $(document).on("keydown","input",function(key){
        if(key.keyCode == 13){
            return false;
        }else{
            return true;
        }
    }).on("keydown","input[name=url]",submiting);
    $("#submit").click(submiting);
    function isFormData(method,json){

        return !((method == "POST" || method=="PUT") && json == true);
    }
    function getKVObject(id){
        let inputDiv = $("#" + id).find("table tr");
        let obj = {};
        $.each(inputDiv,function(index,item){
            let key = $(item).find(".key").val();
            let value = $(item).find(".value").val();
            if("" === key && "" === value){
                return;
            }
            obj[$(item).find(".key").val()] = $(item).find(".value").val();
        });
        return obj;

    }
    function forRequest(form, getKVObject) {
        request = new Request();
        request.url = form.find(":input[name=url]").val();
        request.method = form.find("#method option:selected").val();
        request.cookies = getKVObject("cookies_div");
        request.headers = getKVObject("headers_div");
        request.isJson = form.find(":input[name=isjson]").prop("checked");
        if(isFormData(request.method,request.isJson)){
            request.params = getKVObject("parameters_div");
        }else{
            request.json = $("textarea[name=json]").val();
        }
        return request;
    }
    function renderTable(obj){
        let $table = $("<table class=\"table table-striped table-hover inputs table-bordered\"></table>");
        $table.append("<tr><th class=\"keytr\">key</th><th class=\"valuetr\">value</th></tr>");
        for(var a in obj){
            if((typeof obj[a]) != "object"){
                $table.append('<tr><td>'+ a +'</td><td>'+ obj[a].toString() +'</td></tr>');
            }
        }
        return $table;
    }
})

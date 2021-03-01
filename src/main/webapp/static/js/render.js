
$(function(){
    // 为kv对设置初始化
    let kv = $('.kvs');
    let res = $(".response");
    let kvres = $(".kvs,.response");
    $.each(kvres,function (index,item) {
        if($(item).attr("display") == "true"){

        }else{
            $(item).css("display","none");
        }
    })
    kv.find(".inputs").append($("<tr><th class=\"keytr\">key</th>" +
        "<th class=\"valuetr\">value</th>" +
        "<th class=\"updown\"></th>" +
        "<th class=\"delete\"></th></tr>"));
    addParam(kv.find(".inputs"),1);
    /**
     * tag条点击事件
     */
    $(".nav1").click(function(){
        if(!$(this).hasClass("active")){
            let divid = $(this).siblings(".active").attr("id") + "_div";
            $("#" + divid).css("display","none");
            $(this).siblings(".active").removeClass("active");
            $(this).addClass("active");
            let divid2 = $(this).attr("id") + "_div";
            $("#" + divid2).css("display","block");
        }
        return false;
    })
})
$(document).on("click",".addParam",function () {
    addParam($(this).parent(".kvs").find(".inputs"),1);
})

/**
 * 在元素中追加kv输入框
 * @param ele 需要增加kv元素的元素
 * @param n 个数
 */
function addParam(ele,n){
    while(n){
        n = n - 1;
        let params = kvInput();
        ele.append(params);
    }
}
// function kvInput(){
//     let kvDiv = $("<div class='kv'></div>");
//     let parameterBox = $("<input class='key' /><input class='value'/>");
//     return kvDiv.append(parameterBox);
// }
/**
 * 获取一个kv输入框
 * @returns {jQuery}
 */
function kvInput(){
    let key = $("<td class='keytr'><input class='key form-control' placeholder='key'/></td>");
    let value = $("<td class='valuetr'><input class='value form-control' placeholder='value'/></td>");
    let updown = $("<td class='updown'></td>");
    updown.append("<button class='up btn btn-primary dropdown-toggle'>" +
        "&#8593;</button>");
    updown.append("<button class='down btn btn-primary dropdown-toggle" +
        "'>&#8595;</button>");
    let del = $("<td class='delete'></td>");
    del.append($("<button type=\"button\" class=\"close\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"));
    let $tr = $('<tr></tr>').append(key).append(value).append(updown).append(del);
    $(".close").click(function(){
        $(this).parent().parent().remove();
    })

    return $tr;
}
$(document).on("focus",".key,.value",function(){
    $(this).css("border-color","#ccc");
}).on("blur",".key,.value",function(){
    $(this).css("border-color","rgba(255,255,255,0.1)");
})

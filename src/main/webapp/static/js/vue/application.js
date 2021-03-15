class Request{
    url;
    method="POST";
    params;
    cookies;
    headers;
    json;
    isJson;
}
let app = Vue.createApp({
    data(){
        return {
            requestmethods: ["POST","GET","DELETE","PUT"],
            requesting: new Request(),
            requestInfos: ["parameters","cookies","headers","json"]
        }
    }
})
window.onload = function(){
    let vm = app.mount("#mainarea");
}

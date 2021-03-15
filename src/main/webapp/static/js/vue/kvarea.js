app.component('block-area',{
    props:{
        presentations: {
            type: string,
            required: true
        }
    },
    template: ` <div id="kvarea">
            <ul class="nav nav-tabs">
                <li v-for="presentation in presentations"
                @click="" :id="presentation" class="nav1"><a href="#">{{presentation.toUpperCase()}}</li>
            </ul>
            <div id="parameters_div" class="kvs" display="true">
                <button type="button" class="btn btn-default btn-lg addParam">
                    +
                </button>
                <br>
                <span class="subtitle">Parameters: only valid when method is post or put</span>
                <table class="table table-striped table-hover inputs table-bordered">

                </table>
            </div>
            <div id="cookies_div" class="kvs">
                <button type="button" class="btn btn-default btn-lg addParam">
                    +
                </button>
                <br>
                <span class="subtitle">Cookies</span>
                <table class="table table-striped table-hover inputs table-bordered">

                </table>
            </div>
            <div id="headers_div" class="kvs">
                <button type="button" class="btn btn-default btn-lg addParam">
                    +
                </button>
                <br>
                <span class="subtitle">Headers:</span>
                <table class="table table-striped table-hover inputs table-bordered">

                </table>
            </div>
        </div>`
})
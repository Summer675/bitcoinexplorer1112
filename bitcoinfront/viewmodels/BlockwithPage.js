var app = new Vue({
    el: '#app',
    data: {
        blockwithPage: [],
       
        total:0,
        pageSize:0,
    },
    methods: {
        getBlockwithPage(pageNum) {
            axios.get('/block/getWithPage',{params:{pageNum:pageNum}})
                .then(function (res) {
                    console.log(res);
                    console.log(pageNum);
                    this.blockwithPage=res.data.list;
                    this.total=res.data.total;
                    this.pageSize=res.data.pageSize;
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
                .finally(function () {
                    // always executed
                });
        },
        currentChange(pageNum){
            this.getBlockwithPage(pageNum);
        }
    },
    mounted() {
            this.getBlockwithPage();
    }
})
var app = new Vue({
    el: '#app',
    data: {
        blockwithPage: [],
       
        total:0,
        pageSize:0,
    },
    methods: {
        getBlockwithPage(page) {
         
            axios.get('/block/getWithPage',{params:{page:page}})
                .then(res=>{
                    console.log(res);
                    
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
        currentChange(page){
            this.getBlockwithPage(page);
        }
    },
    mounted() {
            this.getBlockwithPage();
    }
})
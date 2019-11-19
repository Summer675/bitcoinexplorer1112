var app = new Vue({
    el: '#app',
    data: {
        blocks: []
    },
  methods: {
        getBlocks() {
            axios.get('/block/getRecentBlock')
                .then(res=> {
                    console.log(res);
                    app.blocks = res.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted() {
        this.getBlocks();
    },
    computed: {
        newBlocks() {
            return this.blocks.map(block => {
                var newBlock = block;
                newBlock.fornow = moment.unix(block.time).fromNow();
                return newBlock;
            });
        }
    },
})
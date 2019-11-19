<template>
  <div class="hello">
    <el-table :data="newBlocks" style="width: 100%">
      <el-table-column prop="height" label="Height" width="180"></el-table-column>
      <el-table-column prop="blockhash" label="Hash" width="180">
          <template slot-scope="scope">
                    <div class="blockhash">
                        {{'0..' + scope.row.blockhash.substr(12)}}
                    </div>
                </template>
      </el-table-column>
      <el-table-column prop="fornow" label="Mined" width="180"></el-table-column>
      <el-table-column prop="miner" label="Miner" width="180"></el-table-column>
      <el-table-column prop="size" label="Size" width="180">
         <template slot-scope="scope">
                    {{scope.row.size.toLocaleString()}} bytes
                </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "../api/common";
import moment from "../api/moment.min";
export default {
  name: "HelloWorld",
  data() {
    return {
      block: []
    };
  },
  methods: {
    getBlocks() {
      axios
        .get("/block/getRecentBlock")
        .then(res=> {
          this.block=res.data;
        })
        .catch(function(error) {
          
          console.log(error);
        })
        .finally(function() {
          
        });
    }
  },
  mounted() {
    this.getBlocks();
  },
   computed: {
        newBlocks() {
            return this.block.map(block => {
                var newBlock = block;
                newBlock.fornow = moment.unix(block.time).fromNow();
                return newBlock;
            });
        }
    },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

var vm = new Vue({
    el: '#testList',
    data: function () {
        return {
            //主页list
            testList: [],
            classId:'1',
            options: [{
                value: '1',
                label: '语文'
            }, {
                value: '2',
                label: '数学'
            }, {
                value: '3',
                label: '英语'
            }],
        }
    },
    methods: {
        change:function(){
          console.log('aa')
        },
        listAll: function () {
            var _this = this;
            var data = {
                method: 'get',
                url: '/statistics?classId='+_this.classId,
            };
            axios(data).then(function (rs) {
                if (rs.data === 403) {
                    //window.parent.location.href = "/view/login/login.htm";
                }
                if (rs.status === 200) {
                    if (rs.data.length > 0) {
                        _this.testList = rs.data;
                    } else {
                        _this.testList = [];
                    }
                } else {
                    _this.$message.error(data.msg);
                }
            }).catch(function (error) {

            })
        },
    },

    updated: function () {
        this.$refs.myTable.doLayout();
    },
    mounted: function () {
        this.listAll();
    }
});

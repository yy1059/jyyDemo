<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  style="width: 100%;height: 100%">
<head>
    <title></title>
    <link rel="stylesheet" href="https://unpkg.zhimg.com/element-ui@2.13.2/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="/static/css/sys/test/list.css?v=1.0">
    <link rel="stylesheet" href="/static/css/sys/common.css">
</head>
<body style="height: 97%" v-cloak>
<div id="testList" style="height: 97%">
    <%--    导航--%>
    <hr class="myHr">
    <%--    列表--%>
    <div class="myTableDiv" id="myTableDiv">
        <el-table
                ref="myTable"
                id="myTableDiv"
                :data="testList"
                size="small"
                style="width: 100%;border-radius: 10px 10px 0 0;overflow-x: auto">
            <el-table-column
                    type="index"
                    width="50">
            </el-table-column>
            <el-table-column
                    prop="studentName"
                    label="学生姓名"
                    show-overflow-tooltip
                   >
            </el-table-column>
            <el-table-column
                    label="学号"
                    prop="num"
                    show-overflow-tooltip
                   >
            </el-table-column>
            <el-table-column
                    prop="achievement"
                    label="分数"
                    >
            </el-table-column>
            <el-table-column
                    prop="viewVideoNum"
                    label="观看视频次数"
                    sortable="custom"
                    >
            </el-table-column>
            <el-table-column
                    prop="downloadCoursewareNum"
                    label="课件下载次数">
            </el-table-column>
            <el-table-column
                    label="课程名称">
                <template slot-scope="scope">
                   {{className}}
                </template>
            </el-table-column>
        </el-table>

        <hr style="height: 50px;width: 100%;border: 0;margin: 0"/>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://unpkg.zhimg.com/element-ui@2.13.2/lib/index.js"></script>
<script src="/static/js/sys/test/list.js"></script>
</html>


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="https://unpkg.zhimg.com/element-ui@2.13.2/lib/theme-chalk/index.css">
    <title>Title</title>
</head>
<body>
<div id="testList" style="height: 97%">
    <%--    导航--%>
    <hr class="myHr">
    <div>
        <el-select @change="listAll" v-model="classId" placeholder="请选择">
            <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
        </el-select>
    </div>
    <%--    列表--%>
    <div class="myTableDiv" id="myTableDiv">
        <el-table
                ref="myTable"
                id="myTableDiv"
                :data="testList"
                size="small"
                style="width: 100%;border-radius: 10px 10px 0 0;overflow-x: auto">
            <el-table-column
                    label="排名"
                    type="index"
                    width="100">
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
            >
            </el-table-column>
            <el-table-column
                    prop="downloadCoursewareNum"
                    label="课件下载次数">
            </el-table-column>
            <el-table-column
                    label="课程名称">
                <template slot-scope="scope">
                    {{options[classId-1].label}}
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
<script charset="utf-8" src="/static/js/sys/test/list.js"></script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/08/01 001
  Time: 下午 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="box-footer">
    <div class="pull-left ">
        <div class="form-group form-inline">
            总共${pb.pages}页，共${pb.total}条数据。
            每页 <select id="selectPageSize" class="form-control" onchange="gotoPage(1,this.value)">
            <c:forEach var="num" begin="1" end="10" step="1">
                <<%--默认选中 ${num==pb.pageSize ? 'selected':''}--%>
                <option value="${num}" ${num==pb.pageSize ? 'selected':''}>${num}</option>
            </c:forEach>
        </select> 条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li><a href="javascript:gotoPage(1,'${pb.pageSize}')" aria-label="Previous">首页</a></li>
            <li><a href="javascript:gotoPage('${pb.prePage}','${pb.pageSize}')">上一页</a></li>
            <c:forEach var="num"
                       begin="${(pb.pageNum-5)<1?1:(pb.pageNum-5)}"
                       end="${(pb.pageNum+4)>pb.pages ? pb.pages:(pb.pageNum+4)}" step="1">
                <li>
                    <a href="javascript:gotoPage('${num}','${pb.pageSize}')">
                            <%--num值如果是当前页.添加颜色--%>
                        <c:choose>
                            <c:when test="${num==pb.pageNum}">
                                <span style="color: red">${num}</span>
                            </c:when>
                            <c:otherwise>${num}</c:otherwise>
                        </c:choose>
                    </a>
                </li>
            </c:forEach>
            <li><a href="javascript:gotoPage('${pb.nextPage}','${pb.pageSize}')">下一页</a></li>
            <li><a href="javascript:gotoPage('${pb.pages}','${pb.pageSize}')" aria-label="Next">尾页</a></li>
        </ul>
    </div>
</div>
<!-- /.box-footer-->
<script type="text/javascript">
    function gotoPage(pageNum, pageSize) {
        //往表单隐藏域设置值
        $("#pageNum").val(pageNum);
        $("#pageSize").val(pageSize);
        //提交表单
        document.forms[0].submit();
    }

</script>


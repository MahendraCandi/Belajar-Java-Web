<HTML>
    <HEAD>
        <TITLE>Get submit button value</TITLE>
    </HEAD>

    <BODY>
        <H1>Using Multiple Forms</H1>
        <% 
            if(request.getParameter("submit") != null) {
        %>
            You clicked 
            <%= request.getParameter("submit") %>
        <%
            }
        %>

        <FORM NAME="form1" METHOD="POST">
            <INPUT TYPE="SUBMIT" NAME="submit" VALUE="Button 1">
        </FORM>

        <FORM NAME="form2" METHOD="POST">
            <INPUT TYPE="SUBMIT" NAME="submit" VALUE="Button 2">
        </FORM>

        <FORM NAME="form3" METHOD="POST">
            <INPUT TYPE="SUBMIT" NAME="submit" VALUE="Button 3">
        </FORM>
    </BODY>
</HTML>
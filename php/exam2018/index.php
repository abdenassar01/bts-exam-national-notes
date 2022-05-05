
<html>
<head><meta charset="UTF-8">
    <title>Gestion des demandes de branchements électriques</title>
    <link href="styles.css" rel="stylesheet">
    <script language="JavaScript" >
        function valide(){
             let code = document.getElementById('code').value;
             //let code = document.fcon.code.value;
             if(code2.trim() === ""){
                 alert("code invalid");
             }
        }
    </script>
</head>
<body><center>
    <fieldset style="width:400px">
        <legend><b>Saisissez votre code client </b></legend>
        <form action="rech.php" method="post"  name="fcon">
            <table border="0" align="center" style="width:400px">
                <tr><td colspan="2" align="right">
            <i>
                <u>
                <a href="inscription.php">Nouvelle inscription</a></u></i></td></tr>
                <tr><td>Code client : </td>
                    <td>
                        <input type="text" id="code" name="code">
                    </td>
                </tr>
                <tr><td colspan="2" align="center">
                        <input type="submit" id="valider" name="valider" value="valider" onClick="valide()">
                    </td></tr>
            </table></form></fieldset></center>
</body></html>
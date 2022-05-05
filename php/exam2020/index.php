<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
    <style>
        table, td, th{
            border: black 1px solid;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <?php
        include("connection.php");
    ?>
<h1>Liste des formations</h1>
<table>
    <tr>
        <th>code formation</th>
        <th>Libelle</th>
        <th></th>
    </tr>
    <?php
        $req="select * from formation";
    if (!empty($connection)){
        if ($result = mysqli_query($connection,$req)){
            while($raw = mysqli_fetch_assoc($result)){
                echo "<tr>";
                echo "<td>".$raw['codeF']."</td>";
                echo "<td>".$raw['lielle']."</td>";
                echo "<td><a href='lstben.php?codeF=".$raw['codeF']."'>liste Beneficaires</a> </td>";
            }
        }
    }
?>
</table>
</body>
</html>
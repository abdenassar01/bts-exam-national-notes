<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style>
        table, td, th{
        border: black 1px solid;
        border-collapse: collapse;
        }
    </style>
    <title>
        <?php
        include("connection.php");
        if (!empty($connection)) {
            $resultat = mysqli_query($connection, "Select lielle from formation where codeF = '".$_GET['codeF']."'");
            while ($raw = mysqli_fetch_assoc($resultat)){
                echo $raw['lielle'];
            }
        }
        ?>
    </title>
</head>
<body>
<h1>Liste des beneficaires</h1>

<table>
    <tr>
        <th>Code beneficiare</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>tel</th>
        <th>adress</th>
        <th>Ville</th>
    </tr>
    <?php
    include("connection.php");
    if (!empty($connection)) {
        $resultat = mysqli_query($connection, "Select * from client ");
        while ($raw = mysqli_fetch_assoc($resultat)){
            echo "<tr>";
            echo "<td>".$raw['code']."</td>";
            echo "<td>".$raw['nom']."</td>";
            echo "<td>".$raw['prenom']."</td>";
            echo "<td>".$raw['ville']."</td>";
            echo "<td>".$raw['tel']."</td>";
            echo "<td>".$raw['address']."</td>";
            echo "</tr>";
        }
    }
    ?>
</table>
</body>
</html>

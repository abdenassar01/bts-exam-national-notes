<?php

$conn = mysqli_connect("localhost", "root", "27701", "exam2020");
$code = $_POST['code'];
$resultat = mysqli_query($conn, "select * from client where code = " .$code);

session_start();

if (mysqli_num_rows($resultat) !== 0) {
    while ($raw = mysqli_fetch_assoc($resultat )){
        $_SESSION['code_client'] = $raw['code'];
        $_SESSION['nom'] = $raw['nom'];
        $_SESSION['prenom'] = $raw['prenom'];
        $_SESSION['civilite'] = $raw['civilite'];
        include("afficher.php");
    }
}else{
    header('Location: index.php');
}
?>

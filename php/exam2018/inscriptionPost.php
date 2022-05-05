<?php

$conn = mysqli_connect("localhost", "root", "27701", "exam2020");
$code = $_POST['code'];
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$civilite = $_POST['civilite'];
$adress = $_POST['adresse'];
$ville = $_POST['ville'];
$mail = $_POST['email'];
$tel = $_POST['tel'];

if (!$conn){
    echo 'erreur de connection';
}

$resultat = mysqli_query($conn, "select * from client where code = " .$code);

if (mysqli_num_rows($resultat) > 0) {
    echo "<h1>code deja ajouter</h1>";
}else{
    if (mysqli_query( $conn ,"insert into client values($code, '$nom', '$prenom', '$civilite', '$adress', '$ville', '$tel');")){
        echo "<h1>Client Ajouter</h1>";
    }
}
?>

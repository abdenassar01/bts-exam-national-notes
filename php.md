# PHP

- _method getConnection pour etablir une connection utilisant un fonction_
```
    function getConnection(){
      $connection = mysqli_connect("server", "username", "password", "db_name");
    
      if (mysqli_connect_errno()){
        die(mysqli_connect_error());
      }
      return $connection;
    }
  ```
- _verifier validation d'un textbox javascript_
```
        function valide(){
             let code = document.getElementById('code').value;
             //let code = document.fcon.code.value;
             if(code2.trim() === ""){
                 alert("code invalid");
             }
        }
```

et ajouter ```onClick="valide()"``` comme attribut en button
```     
<input type="submit" id="valider" name="valider" value="valider" onClick="valide()">
```

- _remplire un table avec lien hypertext_
```
    $result = mysqli_query($connection,"select * from formation")
    while($raw = mysqli_fetch_assoc($result)){
        echo "<tr>";
        echo "<td>".$raw['codeF']."</td>";
        echo "<td>".$raw['lielle']."</td>";
        echo "<td><a href='lstben.php?codeF=".$raw['codeF']."'>liste Beneficaires</a> </td>";
        echo "</tr>";
    }
```

- _remplire un table html utilisant code envoiyer par un lien hypertext_

```
    $resultat = mysqli_query($connection, "Select * from client c inner join formation f on f.codef = c.codef where c.codef =".$_GET['codeF']);
    while ($raw = mysqli_fetch_assoc($resultat)){
        echo "<tr>";
        echo "<td>".$raw['code']."</td>";
        echo "<td>".$raw['nom']."</td>";
        echo "<td>".$raw['tel']."</td>";
        echo "</tr>";
    }
```

- _Vérifier l’unicité de code client et Enregistrer toutes les informations du formulaire dans la table « Client » si ce code est unique.
  Dans le cas contraire, afficher un message d’erreur dans une boite de dialogue._

```
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
```

- Récupérer le code client de la page «index.php».
- Vérifier l’existence d’un client ayant le code récupéré précédemment.
- Mémoriser, si le code existe, dans une session les champs : code client, nom, prénom et civilité,
  puis inclure le fichier « affiche.php » déjà existant.
- Rediriger, dans le cas contraire, vers la page «index.php».

```

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
```
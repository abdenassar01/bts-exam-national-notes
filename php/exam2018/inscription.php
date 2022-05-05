<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <form action='inscriptionPost.php' method='POST' name="fvald">
        <label for="">code client: </label>
        <input type="text" name="code" id="code"><br>
        <label for="">civilite: </label>
        <select name="civilite" id="">
            <option value="mr">Mr</option>
            <option value="mll">Melle</option>
        </select><br>
        <label for="">nom du client:</label><input type="text" name="nom" id="nom"><br>
        <label for="">prenom du client:</label><input type="text" name="prenom" id="prenom"><br>
        <label for="adr">adress</label>
        <textarea name="adresse" id="" cols="30" rows="10"></textarea><br>
        <label for="ville">ville</label><input type="text" name="ville"><br>
        <label for="email">email</label><input type="text" name="email"><br>
        <label for="tel">Telephone</label><input type="text" name="tel"><br>
        <input type="submit" value="valide" name="valide"><br>
    </form>
</body>
</html>
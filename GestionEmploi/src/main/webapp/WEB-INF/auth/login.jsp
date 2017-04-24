<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gestion des emplois</title>
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/dist/css/simple-sidebar.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Arima+Madurai:400,300,500,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
</head>

<body>

<div class="login">
	<div class="form-auth">
		<h1 class="title">Connexion</h1>
		<c:if test="${err != ''}">
			<div class="alert alert-danger" role="alert">
			  ${err}
			</div>
		</c:if>
		<form action="" method="POST">
			<div class="form-group">
				<label for="email">Adresse E-mail</label>
				<input type="email" class="form-control" name="email" id="email" placeholder="Adresse E-mail">
			</div>
			<div class="form-group">
				<label for="password">Mot de passe</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="Mot de passe">
			</div>
			<button class="btn btn-block btn-success">Se connecter</button>
		</form>
		
	</div>
</div>

<script src="/dist/js/jquery.js"></script>
<script src="/dist/js/bootstrap.min.js"></script>
<script src="/dist/js/bootstrap-toolkit.min.js"></script>
<script src="/dist/js/main.js"></script>

</body>

</html>
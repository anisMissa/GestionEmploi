
<%

if (session.getAttribute("user") ==null) {

	session.invalidate();
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
	response.sendRedirect("/login");
}
%>
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
    <div class="navbar navbar-inverse navbar-fixed-top" id="search-box">
        <div class="container">
            <form class="navbar-form">
                <div class="form-group" style="display:inline;">
                    <div class="input-group" style="display:table;">
                        <span class="input-group-addon" id="closeSearchBox" style="width:1%;"><span class="fa fa-lg fa-times"></span></span>
                        <input class="form-control" name="search" placeholder="Recherche rapide..." autofocus="autofocus" type="text">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <nav class="navbar navbar-custom navbar-fixed-top">
        <div class="container-fluid" style="margin-bottom: -8px;">
            <div class="navbar-header">
                <a class="visible-xs navbar-brand heading" href="#toggleSideBar" id="toggleSideBar"><i class="fa fa-lg fa-bars" aria-hidden="true"></i></a>
                <a class="navbar-brand heading" href="#">
                    <span class="hidden-xs">
                        <img src="/dist/img/logo.png">Ecole polytechnique
                    </span>
                </a>
            </div>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav navbar-left" >
                    
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle notifiable" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <div class="text-center">5</div>
                            <i class="fa fa-lg fa-envelope-o" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle notifiable" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <div class="text-center">16</div>
                            <i class="fa fa-lg fa-bell" aria-hidden="true"></i>
                        </a>
                    </li>
                    <li id="openSearchBox"><a href=""><i class="fa fa-lg fa-search" aria-hidden="true"></i></a></li>
                    <li class="visible-xs"><a href=""><i class="fa fa-lg fa-sign-out" aria-hidden="true"></i></a></li>
                    <li class="dropdown hidden-xs">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <img src="/dist/img/user-profile.png" class="user">
                            <span class="hidden-xs">Dropdown</span> <span class="hidden-xs caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="fa mr fa-user" aria-hidden="true"></i>Mon compte</a></li>
                            <li><a href="#"><i class="fa mr fa-cogs" aria-hidden="true"></i>Paramètres</a></li>
                            <li><a href="#"><i class="fa mr fa-question-circle" aria-hidden="true"></i>Aide</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/login/out"><i class="fa mr fa-sign-out" aria-hidden="true"></i>Déconnexion</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

<div id="wrapper">
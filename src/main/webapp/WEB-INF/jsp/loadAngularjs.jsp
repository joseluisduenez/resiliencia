<HTML>
	<head>
		<link rel="stylesheet" href="/css/bootstrap.min.css" >
		<script src="/js/angular1.6.4.min.js"></script>
		<script src="/js/angular-route1.6.4.js"></script>
		
		<script src="/js/bootstrap.min.js"></script>
		
		<script src="/js/routing/routing.js"></script>
				<script src="/js/controllers/loginController.js"></script>
		
		<style>
		  .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;}
		</style>
		
	</head>
	<BODY>
		 <div ng-app="resiliencia" >
		 <div ng-view></div>
		 
		  
<ul>
  <li ng-repeat="x in names">
    {{ x.name + ', ' + x.country }}
  </li>
</ul>

		</div>
	</BODY>
</HTML>
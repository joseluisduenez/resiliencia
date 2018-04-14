<HTML>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="/js/angular1.6.4.min.js"></script>
		<style>
		  .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;}
		</style>
	</head>
	<BODY>
		 <div ng-app="">
		  <p>Name : <input type="text" ng-model="name"></p>
		  <h1>Hello {{name}}</h1>
		</div>
	</BODY>
</HTML>
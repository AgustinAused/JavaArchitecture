<!DOCTYPE html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/validacion.js" ></script>
<meta charset="UTF-8"> 
<title>Formulario libro</title>
</head>
<body>

	<h1>Formulario Alta de libros</h1>

	<form action="InsertBook" onsubmit="return validation();">
		<div class="form-group">
			<label for="isbn">ISBN</label> <input type="text"
				class="form-control" id="isbn" name="isbn"
				placeholder = "aqui el ISBN" />
		</div>

		<div class="form-group">
			<label for="titulo">Título</label> <input type="text"
				class="form-control" id="titulo" name="titulo"
				placeholder = "aqui el titulo del libro" />
		</div>

		<div class="form-group">
			<label for="categoria">Categoría</label> <input type="text"
				class="from-control" id="categoria" name="categoria"
				placeholder = "aqui la categoria del libro" />
		</div>

		<p>
			<button type="submit" class="btn btn-primary">Guardar</button>
		</p>
	</form>
</body>
</html>


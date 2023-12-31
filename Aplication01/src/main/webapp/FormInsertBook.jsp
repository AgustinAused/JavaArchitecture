<!DOCTYPE html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/validacion.js" ></script>
<meta charset="UTF-8"> 
<title>Formulario libro</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 15px 20px;
            font-size: 16px;
            border: none;
            cursor: pointer;
            margin: 10px 0;
            border-radius: 5px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

	<h1>Formulario Alta de libros</h1>

	<form action="InsertBook" onsubmit="return validation();">
        <div class="form-group">
            <label for="isbn">ISBN</label>
            <input type="text" class="form-control" id="isbn" name="isbn" placeholder="Aqui el ISBN" />
        </div>

        <div class="form-group">
            <label for="titulo">Título</label>
            <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Aqui el título del libro" />
        </div>

        <div class="form-group">
            <label for="categoria">Categoría</label>
            <input type="text" class="form-control" id="categoria" name="categoria" placeholder="Aqui la categoría del libro" />
        </div>

        <p>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </p>
    </form>
</body>
</html>


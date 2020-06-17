#Sistema para cadastro de usuários com spring boot, thymeleaf, jquery, bootstrap, font-awesome
<br />
<form action="/adduser" method="post">
							<label for="nome">Nome : </label> <input type="text"
								id="nome" placeholder="Nome"
								class="form-control" aria-label="Small" onfocus="this.value=''" name="nome" value=""> <span  >* é Obrigatório</span><br>
							<label for="email">Email : </label> <input type="text"
								id="email" placeholder="Email"
								class="form-control" aria-label="Small" onfocus="this.value=''" name="email" value="" > <span
								class="glyphicon glyphicon-envelope">*</span><br>
								
								
								<label for="telefone">Telefone : </label> <input type="text" 
								id="telefone" name="telefone" placeholder="telefone"
								class="form-control" aria-label="Small" onfocus="this.value=''" value="" > <span
								class="glyphicon-phone-alt
">*</span><br>
								
								<label for="celular">Celular : </label> <input type="text" 
								id="celular" name="celular" placeholder="celular"
								class="form-control" aria-label="Small" onfocus="this.value=''" value="" > <span
								class="glyphicon-phone">*</span><br>
								
							<button type="submit" class="btn btn-info btn-lg" title="Salvar"><i class="fa fa-save fa-lg"></i>
							</button>
						</form>

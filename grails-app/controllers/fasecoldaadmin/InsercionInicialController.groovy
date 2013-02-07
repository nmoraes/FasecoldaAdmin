package fasecoldaadmin

class InsercionInicialController {
	
	def NewBrandsService;
	
	
	
	def cargaInicial ={
		System.out.println("Se va a ejecutar la carga inicial en motors DB ........");

		NewBrandsService.buildSiteBrands("MCO");// site.id
		
		redirect(controller:"insercionInicial", action: "list")
			
		}
	
	def mostrarBrands ={
		System.out.println("mysql> select * from brands;");
		NewBrandsService.mostrarBrands();
		redirect(controller:"insercionInicial", action: "list")
		}
	
	
	
	def mostrarBrandsModel={
		System.out.println("mysql> select * from brands-model;");
		NewBrandsService.mostrarBrandsModel();
		redirect(controller:"insercionInicial", action: "list")
		
		}
	
	
	
	def mostrarCategory={
		System.out.println("mysql> select * from category;");
		NewBrandsService.mostrarCategory();
		redirect(controller:"insercionInicial", action: "list")
		
		}
	
	
	def mostrarCategoryBrand={
		System.out.println("mysql> select * from category_brand;");
		NewBrandsService.mostrarCategoryBrand();
		redirect(controller:"insercionInicial", action: "list")
		
		}
	
	

	
	
	
	
	

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
		
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [insercionInicialInstanceList: InsercionInicial.list(params), insercionInicialInstanceTotal: InsercionInicial.count()]
    }
}

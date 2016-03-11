'use strict';

var app = angular.module('ngdemo');

angular.module('ngdemo.ctrlPatrocinador', [])
    .controller('ControllerPatrocinador', ControllerPatrocinador)

ControllerPatrocinador.$inject = ['$scope', 'Restangular'];

function ControllerPatrocinador($scope, Restangular) {
    
    init();
    atualizaLista();
    

    function init(){
        $scope.paginas = 5;
        setarLinhas($scope.paginas); 
    };
      
    function setarLinhas(num){
        if (num == 'Todas'){
            num = $scope.patrocinadores.length;
        }
        $scope.entryLimit = num;
    };
     
    $scope.ordenarPor = function(coluna) {
        $scope.criterioDeOrdenacao = coluna;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };

    $scope.setItemsPagina = function(num) {
        setarLinhas(num);       
    };
    
   function atualizaLista(){
        Restangular.all("patrocinadores").getList().then(function (objeto) {
            $scope.patrocinadores = objeto;
            setarLinhas($scope.paginas);
        });
   };

   $scope.createNewPatrocinador = function () {             
        Restangular.all('patrocinadores').post($scope.patrocinador).then(function(){
            atualizaLista();
            $scope.patrocinador = null;
        });
   };
   
   $scope.deletePatrocinador = function (patrocinadorId) {
        Restangular.one('patrocinadores', patrocinadorId).remove().then(function(){
           atualizaLista();
        });       
    };
    
      
   $scope.updatePatrocinador = function () {  
        var copiaItem = Restangular.copy($scope.patrocinador);
        $scope.patrocinador = copiaItem.put().then(function(){
            $scope.patrocinador = null;
            atualizaLista(); 
        });
    };
    
   $scope.carregaPatrocinador = function (patrocinadorId) {
        $scope.patrocinador = Restangular.one("patrocinadores",patrocinadorId).get().$object;
   };
   
    $scope.limpaVariaveis = function () {
        $scope.patrocinador = null;
    };
}

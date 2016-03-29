'use strict';

var app = angular.module('ngdemo');

angular.module('ngdemo.ctrlDespesa', [])
    .controller('ControllerDespesa', ControllerDespesa)

ControllerDespesa.$inject = ['$scope', 'Restangular'];

function ControllerDespesa($scope, Restangular) {
    
    init();
    atualizaLista();

    function init(){
        $scope.paginas = 5;
        setarLinhas($scope.paginas); 
    };
      
    function setarLinhas(num){
        if (num == 'Todas'){
            num = $scope.despesas.length;
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
        Restangular.all("despesas").getList().then(function (objeto) {
            $scope.despesas = objeto;
            setarLinhas($scope.paginas);
        });
   };

   $scope.createNewDespesa = function () {             
        Restangular.all('despesas').post($scope.despesa).then(function(){
            atualizaLista();
            $scope.despesa = null;
        });
   };
   
   $scope.deleteDespesa = function (despesaId) {
        Restangular.one('despesas', despesaId).remove().then(function(){
           atualizaLista();
        });       
    };
    
      
   $scope.updateDespesa = function () {  
        var copiaItem = Restangular.copy($scope.despesa);
        $scope.despesa = copiaItem.put().then(function(){
            $scope.despesa = null;
            atualizaLista(); 
        });
    };
    
   $scope.carregaDespesa = function (despesaId) {
        $scope.despesa = Restangular.one("despesas",despesaId).get().$object;
   };
   
    $scope.limpaVariaveis = function () {
        $scope.despesa = null;
    };
}

'use strict';

var app = angular.module('ngdemo');

angular.module('ngdemo.ctrlTime', [])
    .controller('ControllerTime', ControllerTime)

ControllerTime.$inject = ['$scope', 'Restangular'];

function ControllerTime($scope, Restangular) {
    
    init();
    atualizaLista();

    function init(){
        $scope.paginas = 5;
        setarLinhas($scope.paginas); 
    };
      
    function setarLinhas(num){
        if (num == 'Todas'){
            num = $scope.times.length;
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
        Restangular.all("times").getList().then(function (objeto) {
            $scope.times = objeto;
            setarLinhas($scope.paginas);
        });
   };

   $scope.createNewTime = function () {             
        Restangular.all('times').post($scope.time).then(function(){
            atualizaLista();
            $scope.time = null;
        });
   };
   
   $scope.deleteTime = function (timeId) {
        Restangular.one('times', timeId).remove().then(function(){
           atualizaLista();
        });       
    };
    
      
   $scope.updateTime = function () {  
        var copiaItem = Restangular.copy($scope.time);
        $scope.time = copiaItem.put().then(function(){
            $scope.time = null;
            atualizaLista(); 
        });
    };
    
   $scope.carregaTime = function (timeId) {
        $scope.time = Restangular.one("times",timeId).get().$object;
   };
   
    $scope.limpaVariaveis = function () {
        $scope.time = null;
    };
}

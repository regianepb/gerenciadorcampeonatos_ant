'use strict';

var app = angular.module('ngdemo');

angular.module('ngdemo.ctrlJogador', [])
    .controller('ControllerJogador', ControllerJogador);

ControllerJogador.$inject = ['$scope', 'Restangular'];

function ControllerJogador($scope, Restangular) {
    
    init();
    atualizaLista();

    function init(){
        $scope.paginas = 5;
        setarLinhas($scope.paginas); 
    };
      
    function setarLinhas(num){
        if (num == 'Todas'){
            num = $scope.jogadores.length;
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
        Restangular.all("jogadores").getList().then(function (objeto) {
            $scope.jogadores = objeto;
            setarLinhas($scope.paginas);
        });
   };

   $scope.createNewJogador = function () {     
       console.log($scope.jogador);
        Restangular.all('jogadores').post($scope.jogador).then(function(){
            atualizaLista();
            $scope.jogador = null;
        });
   };
   
   $scope.deleteJogador = function (jogadorId) {
        Restangular.one('jogadores', jogadorId).remove().then(function(){
           atualizaLista();
        });       
    };
    
      
   $scope.updateJogador = function () {  
        var copiaItem = Restangular.copy($scope.jogador);
        $scope.jogador = copiaItem.put().then(function(){
            $scope.jogador = null;
            atualizaLista(); 
        });
    };
    
   $scope.carregaJogador = function (jogadorId) {
        $scope.jogador = Restangular.one("jogadores",jogadorId).get().$object;
   };
   
    $scope.limpaVariaveis = function () {
        $scope.jogador = null;
    };
}

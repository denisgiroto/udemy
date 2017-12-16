(function(){

    angular.module('app').controller('BillingCycleCtrl',[
        '$http',
        '$location',
        'msgs',
        'tabs',
        BillingCycleController
    ]);
    
    function BillingCycleController( $http ,$location, msgs, tabs ){
    
        const vm = this;
        const url = 'http://localhost:3003/api/billingCycles';

       

        vm.refresh = function(){
            
            const page = parseInt($location.search().page) || 1;
            console.log('ctrl page = ', page);

            $http.get(`${url}?skip=${(page - 1) * 10}&limit=10`)
                .then( function(response){
                    
                    vm.billingCycle = { credits:[{}], debts:[{}]};
                    vm.billingCycles = response.data;
                    vm.calculateValues();
                    
                    $http.get(`${url}/count`).then(function(data){
                        
                        vm.pages = Math.ceil(data.data.value / 10);
                        console.log('ctrl pages = ', vm.pages);

                        tabs.show(vm, {tabList:true, tabCreate:true});
                    });
                },
                function( response ){

                    const {errors = []} = response.data;
                });
        }


        vm.create = function(){
            $http.post(url, vm.billingCycle)
                .then( function(response){

                    vm.refresh();
                    msgs.addSuccess('Operação realizada com sucesso!!');
                } ,
                function( response ){

                    const {errors = []} = response.data;
                    console.log(`data ${errors}`);
                    console.log(response.data);
                    msgs.addError( response.data.errors );
                });
        }
        
        vm.showTabUpdate = function(billingCycle){

            vm.billingCycle = billingCycle;
            vm.calculateValues();
            tabs.show(vm, {tabUpdate:true});
        }

        vm.showTabDelete = function(billingCycle){

            vm.billingCycle = billingCycle;
            vm.calculateValues();
            tabs.show(vm, {tabDelete:true});
        }

        vm.update = function(){
            
            const updateUrl = `${url}/${vm.billingCycle._id}`;
            $http.put(updateUrl, vm.billingCycle)
            .then( function(response){
                
                vm.refresh();
                msgs.addSuccess('Operação realizada com sucesso!!');
            } ,
            function( response ){
                console.log(response)
                if(response.data){
                    
                    const {errors = [], status = null} = response.data;
                    
                    if(status === 404){
                        
                        msgs.addError( ['Item já foi excluído.'] );
                    }else{
                        
                        msgs.addError( errors );
                    }
                    
                }else{
                    
                    msgs.addError( ['Erro interno!'] );
                }
            });
           
        }

        vm.delete = function(){

            const deleteUrl = `${url}/${vm.billingCycle._id}`;
            $http.delete(deleteUrl, vm.billingCycle)
            .then( function(response){
                
                vm.refresh();
                msgs.addSuccess('Operação realizada com sucesso!!');
            } ,
            function( response ){
                console.log(response)
                if(response.data){
                    
                    const {errors = [], status = null} = response.data;
                    
                    if(status === 404){
                        
                        msgs.addError( ['Item já foi excluído.'] );
                    }else{
                        
                        msgs.addError( errors );
                    }
                    
                }else{
                    
                    msgs.addError( ['Erro interno!'] );
                }
            });
        }

        vm.addCredit = function(index){

            vm.billingCycle.credits.splice(index + 1,0, {});
        }

        vm.cloneCredit = function(index, {name, value}){

            vm.billingCycle.credits.splice(index + 1,0, {name,value});
            vm.calculateValues();
        }

        vm.deleteCredit = function(index){
            if(vm.billingCycle.credits.length > 1){

                vm.billingCycle.credits.splice(index, 1);
                vm.calculateValues();
            }
        }

        vm.addDebt = function(index){

            vm.billingCycle.debts.splice(index + 1,0, {});
        }

        vm.cloneDebt = function(index, {name, value, status}){

            vm.billingCycle.debts.splice(index + 1,0, {name,value,status});
            vm.calculateValues();
        }

        vm.deleteDebt = function(index){
            if(vm.billingCycle.debts.length > 1){

                vm.billingCycle.debts.splice(index, 1);
                vm.calculateValues();
            }
        }

        vm.calculateValues = function(){
            vm.credit = 0;
            vm.debt = 0;
            
            if(vm.billingCycle){

                vm.billingCycle.credits.forEach( function({value}){
                    
                    vm.credit += !value || isNaN(value) ? 0 : parseFloat(value);
                });

                vm.billingCycle.debts.forEach( function({value}){
                   
                    vm.debt += !value || isNaN(value) ? 0 : parseFloat(value);
                });

            }
            
            vm.total = vm.credit - vm.debt;


        }
    
        vm.refresh();
    }
})();

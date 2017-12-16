angular.module('app').component('valueBox',{
    bindings:{ grid:'@',
               colorClass:'@',
               value:'@',
               text:'@',
               iconClass:'@'
             },
    controller:[
        'gridSystem',
        function(gridSystem){
            //alert(grid);
            //this.gridClasses = gridSystem.toCssClasses(  this.grid ) ;
            //não consegue pegar o valor de this.grid
            
            //denis.giroto
            //this.toCssClasses = (numeros) => gridSystem.toCssClasses( numeros );
            //{{ $ctrl.gridClasses( $ctrl.grid ) }}

            //jeito certo
            this.$onInit = () => this.gridClasses = gridSystem.toCssClasses(this.grid);
        }
    ],
    template:`
       <div class="{{ $ctrl.gridClasses }}">
            <div class="small-box {{ $ctrl.colorClass }}">
                <div class="inner">
                    <h2>{{ $ctrl.value }}</h2>
                    <p>{{ $ctrl.text }}</p>
                </div>
                <div class="icon">
                    <i class="fa {{ $ctrl.iconClass }}"></i>
                </div>
            </div>
        </div>
    `
});
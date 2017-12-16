(function(){

    angular.module('app').component('paginator',{
        bindings:{ url:'@',
            pages:'@'
        },
        controller:[
        '$location',
        function($location){
            
        

            this.$onInit = () => {
                
                const componentPages = parseInt(this.pages) || 1;
                console.log('component pages ' + componentPages );
                
                this.pagesArray = Array( componentPages ).fill(0).map( (e,i)=>i+1 );
                console.log(this.pagesArray);
                
                
                this.current = parseInt($location.search().page) || 1;
                console.log('component current ' + this.current);
                
                
                this.needPagination = componentPages > 1;
                console.log('component needPagination ' + this.needPagination);
                
                this.hasPrev = this.current > 1;
                console.log('component hasPrev ' +this.hasPrev);
                
                this.hasNext = this.current < componentPages;
                console.log('component hasNext ' +this.hasNext);
                
                this.isCurrent = function( i ){
                    return this.current == i;
                }
                console.log('component isCurrent ' +this.isCurrent()); 
            }
            
        }
        ],
        template:`
        <ul ng-if="$ctrl.needPagination" class="pagination pagination-sm no-margin pull-right">
            <li ng-if="$ctrl.hasPrev">
                <a href="{{$ctrl.url}}?page={{$ctrl.current-1}}" >Anterior</a>
            </li>

            <li ng-class="{active: $ctrl.isCurrent(index) }" ng-repeat="index in $ctrl.pagesArray">
                <a href="{{$ctrl.url}}?page={{index}}">{{index}}</a>
            </li>

            <li ng-if="$ctrl.hasNext">
                <a href="{{$ctrl.url}}?page={{$ctrl.current+1}}">Próximo</a>
            </li>

        </ul>
        `
    })
})()
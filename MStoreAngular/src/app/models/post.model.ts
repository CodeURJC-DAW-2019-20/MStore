import {Brand} from './brand.model';
export interface Post {
    id: number;
    nImg:number;
    name:string;
    component:string;
    tags?:string[];
    price:number;
    details:string;
    features:string;
    postAddress:string;
    componentTag:number;
    brand:Brand;
}
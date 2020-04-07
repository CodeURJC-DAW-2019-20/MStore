import { Brand } from './brand.model';
import { User } from './user.model';

export interface Post {
    id?: number;
    nImg?: number;
    name: string;
    component: string;
    tags?: String[];
    price: number;
    details: string;
    features?: string;
    postAddress: string;
    componentTag?: number;
    brand?: Brand;
    user?: User;
}
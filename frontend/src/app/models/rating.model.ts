import { User } from './user.model';

export interface Rating {
    id?: number;
    stars:number;
    buyer:User;
    seller:User;
}
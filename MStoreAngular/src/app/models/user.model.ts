import { Post } from './post.model';

export interface User {
    firstName: string;
    lastName: string;
    email: string;
    userAddress?: string;
    password: string;
    phone: number;
    creditCard?: number;
    roles: Array<string>;
    sellers: Array<User>;
    posts: Array<Post>;
}
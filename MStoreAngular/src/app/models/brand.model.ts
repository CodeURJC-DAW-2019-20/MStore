import { Post } from './post.model'

export interface Brand {
    id: number;
    name: string;
    posts: Post[];
}
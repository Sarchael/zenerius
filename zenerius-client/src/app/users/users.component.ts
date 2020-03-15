import { Component } from '@angular/core';
import { first } from 'rxjs/operators';

import { UserService} from '../services/user.service';
import { UserDetails } from '../_models/userDetails';

@Component({ templateUrl: 'users.component.html' })
export class UsersComponent {
    loading = false;
    userDetails: UserDetails;;

    constructor(private userService: UserService) { }

    ngOnInit() {
        this.loading = true;
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.loading = false;
            this.userDetails = users;
        });
    }
}

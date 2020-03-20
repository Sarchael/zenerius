import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { UserDetails } from '../_models/userDetails';
import { SignUpForm } from '../_models/signUpForm';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<UserDetails>(`${environment.apiUrl}/users/my`);
    }

    save(signUpForm: SignUpForm) {
        return this.http.post<SignUpForm>(`${environment.apiUrl}/users`, signUpForm);
    }
}
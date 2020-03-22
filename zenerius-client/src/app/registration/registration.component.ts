import { Component, OnInit } from '@angular/core';
import { SignUpForm } from '../_models/signUpForm';
import { UserService } from '../services/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  signUpForm: SignUpForm;
  registerForm: FormGroup;
  submitted = false;
  password: string;
  password2: string;
  gender: string;
  error = '';
  returnUrl = '';

  constructor(private userService: UserService, 
    private formBuilder: FormBuilder, 
    private route: ActivatedRoute, 
    private router: Router) { }

  ngOnInit(): void {
    this.signUpForm = new SignUpForm();

    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

    this.registerForm = this.formBuilder.group({
      login: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      password2: ['', Validators.required],
      gender: ['', Validators.required]
    });
  }

  mapFormGroupToSingUpForm() {
    this.signUpForm.login = this.f.login.value;
    this.signUpForm.password = this.f.password.value;
    this.signUpForm.email = this.f.email.value;
    this.signUpForm.gender = this.f.gender.value;
  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    if (this.f.password.value === this.f.password2.value) {
      this.mapFormGroupToSingUpForm();
      this.error = '';
      this.userService.save(this.signUpForm).subscribe(data => {
        this.router.navigate([this.returnUrl]);
      }, err => {
        this.error = "Nieudana rejestracja";
      })
    } else {
      this.error = "Hasła muszą być identyczne";
    }

  }

}

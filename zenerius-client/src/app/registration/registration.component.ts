import { Component, OnInit } from '@angular/core';
import { SignUpForm } from '../_models/signUpForm';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  signUpForm: SignUpForm;
  response: string;
  hide = true;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.signUpForm = new SignUpForm();
    this.hide = true;
  }

  onSubmit(){
    this.signUpForm.gender="M";
    this.userService.save(this.signUpForm).subscribe(data => {
      this.response = "Pomyślnie zarejestrowano użytkownika";
      this.hide = false;
    }, err=> {
      this.hide=false;
        this.response = "Nieudane logowanie";
    })
  }

}

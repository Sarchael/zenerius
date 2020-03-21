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
  password: string;
  password2: string;
  errMessage: string;
  show: boolean;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.signUpForm = new SignUpForm();
    this.show = false;
  }

  onSubmit(){
    this.signUpForm.gender="M";
    if(this.password === this.password2){
      this.userService.save(this.signUpForm).subscribe(data => {
        this.show = false;
      }, err=> {
        this.show = true;
        this.errMessage = "Nieudane logowanie";
      })
    } else {
      this.show = true;
      this.errMessage = "Hasła muszą być identyczne"
    }

  }

}

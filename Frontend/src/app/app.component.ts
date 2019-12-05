import { Component } from '@angular/core';
import {BackendService} from './service/backend.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private backendService: BackendService) {}

  public primLimit: number;
  public fibonacciLimit: number;

  public primList: number[];
  public fibonacciList: number[];

  onPrimSubmit() {
    let listIsSet = false;
    this.backendService.setPrimzahlen(this.primLimit).subscribe((primListSet ) =>  {
      listIsSet = primListSet;
    }, () => {}, () => {
      if (listIsSet) {
        this.backendService.getPrimzahlen().subscribe(primList => this.primList = primList);
      }
    });
  }

  onFibonacciSubmit() {
    let listIsSet = false;
    this.backendService.setFibonacciZahlen(this.fibonacciLimit).subscribe(fibonacciListSet => listIsSet = fibonacciListSet,
      () => {}, () => {
        if (listIsSet) {
          this.backendService.getFibonacciZahlen().subscribe( fibonacciList => this.fibonacciList = fibonacciList);
        }
      });
  }

}

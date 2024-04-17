import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

// TODO: To make the project versatile (default names and images to be made dynamic)
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

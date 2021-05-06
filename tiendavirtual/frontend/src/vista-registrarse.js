import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaRegistrarse extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; flex-direction: row; align-items: center; justify-content: center; flex-wrap: nowrap;">
 <vaadin-vertical-layout style="width: 80%; height: 100%; align-items: center; justify-content: flex-start; flex-direction: column; flex-wrap: nowrap;" id="vaadinVerticalLayout">
  <label id="labelRegistroUsuario">Registro de usuario</label>
  <vaadin-combo-box id="tipoUsuario" style="width: 40%;" label="Tipo de usuario"></vaadin-combo-box>
  <vaadin-text-field id="nombre" style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="Nombre"></vaadin-text-field>
  <vaadin-text-field style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="Apellidos" id="apellidos"></vaadin-text-field>
  <vaadin-text-field label="DNI" placeholder="00000000A" id="dni" style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required></vaadin-text-field>
  <vaadin-text-field style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="Dirección" id="direccion"></vaadin-text-field>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayoutFoto" style="flex-direction: row; align-self: flex-start; flex-wrap: nowrap; align-items: flex-start; justify-content: flex-start; align-content: space-around;">
   <label id="labelFotoPerfil" style="align-self: flex-start; margin: var(--lumo-space-m);">Foto de perfil</label>
   <img id="img" style="width: 100px; height: 100px; align-self: flex-start; margin: var(--lumo-space-m);">
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
   <vaadin-combo-box id="formaDePago" style="width: 20%;" label="Forma de pago"></vaadin-combo-box>
   <vaadin-text-field label="Numero de tarjeta" placeholder="1234 1234 1234 1234" id="numeroTarjeta" style="width: 80%;"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-text-field style="align-self: center; width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="e-mail" id="email"></vaadin-text-field>
  <vaadin-password-field id="password" style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" required label="Contraseña" invalid></vaadin-password-field>
  <vaadin-password-field id="password2" style="width: 100%; margin: var(--lumo-space-m); padding: var(--lumo-space-m);" label="Confirmar contraseña" required invalid></vaadin-password-field>
  <vaadin-button id="registrarseButton" style="width: 200px; height: 50px;">
    Registrarse 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-registrarse';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaRegistrarse.is, VistaRegistrarse);

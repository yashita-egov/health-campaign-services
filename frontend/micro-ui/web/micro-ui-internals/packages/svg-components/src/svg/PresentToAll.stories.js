import React from "react";
import { PresentToAll } from "./PresentToAll";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "PresentToAll",
  component: PresentToAll,
};

export const Default = () => <PresentToAll />;
export const Fill = () => <PresentToAll fill="blue" />;
export const Size = () => <PresentToAll height="50" width="50" />;
export const CustomStyle = () => <PresentToAll style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <PresentToAll className="custom-class" />;
